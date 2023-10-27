package simplenonblockingserver;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Pattern;

class AsynchronousEcho {

  public static void main(String[] args) throws IOException {
    Selector selector = Selector.open();

    ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
    serverSocketChannel.bind(new InetSocketAddress(3000));
    // set channel into non-blocking mode
    serverSocketChannel.configureBlocking(false);
    // selector will notify of incoming connections
    serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

    while (true) {
      // collect all non-blocking I/O notifications
      selector.select();
      Iterator<SelectionKey> it = selector.selectedKeys().iterator();
      while (it.hasNext()) {
        SelectionKey key = it.next();
        if (key.isAcceptable()) {
          // new conncetion
          newConnection(selector, key);
        } else if (key.isReadable()) {
          // a socket has received data
          echo(key);
        } else if (key.isWritable()) {
          // socket is ready for writing data
          continueEcho(selector, key);
        }
        // selection keys need to be manually removed
        it.remove();
      }
    }
  }

  /**
   * Context class keeps state related to handling of a TCP connection.
   * Conrtext depends on app and protocol, here we track the current line and
   * whether the connection is closing and we maintain a connection-specific NIO
   * buffer for reading and writing data.
   */
  private static class Context {
    private final ByteBuffer nioBuffer = ByteBuffer.allocate(512);
    private String currentLine = "";
    private boolean terminating = false;
  }

  // keep all connection states in a hashmap
  private static final HashMap<SocketChannel, Context> contexts = new HashMap<>();

  private static void newConnection(Selector selector, SelectionKey key) throws IOException {
    ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
    SocketChannel socketChannel = serverSocketChannel.accept();
    // set channel to non-blocking and declare interest in read operations
    socketChannel
        .configureBlocking(false)
        .register(selector, SelectionKey.OP_READ);
    contexts.put(socketChannel, new Context());
  }

  private static final Pattern QUIT = Pattern.compile("(\\r)?(\\n)?/quit$");

  private static void echo(SelectionKey key) throws IOException {
    SocketChannel socketChannel = (SocketChannel) key.channel();
    Context context = contexts.get(socketChannel);
    try {
      socketChannel.read(context.nioBuffer);
      context.nioBuffer.flip();
      context.currentLine = context.currentLine + Charset.defaultCharset().decode(context.nioBuffer);
      // if we find a line ending with /quit, we terminate theconnection
      if (QUIT.matcher(context.currentLine).find()) {
        context.terminating = true;
      } else if (context.currentLine.length() > 16) {
        context.currentLine = context.currentLine.substring(8);
      }
      // Java-NIO buffers need positional manipulation: the buffer has read data, so
      // to write it back to the client, we need to flip and return to the start
      // position
      context.nioBuffer.flip();
      int count = socketChannel.write(context.nioBuffer);
      // It may happen that not all the data can be written, so we stop looking for
      // read operations and declare interest in a notification indicating when the
      // channel can be written again.
      if (count < context.nioBuffer.limit()) {
        key.cancel();
        socketChannel.register(key.selector(), SelectionKey.OP_WRITE);
      } else {
        context.nioBuffer.clear();
        if (context.terminating) {
          cleanup(socketChannel);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
      cleanup(socketChannel);
    }
  }

  private static void cleanup(SocketChannel socketChannel) throws IOException {
    socketChannel.close();
    contexts.remove(socketChannel);
  }

  private static void continueEcho(Selector selector, SelectionKey key) throws IOException {
    SocketChannel socketChannel = (SocketChannel) key.channel();
    Context context = contexts.get(socketChannel);
    try {
      int remainingBytes = context.nioBuffer.limit() - context.nioBuffer.position();
      int count = socketChannel.write(context.nioBuffer);
      // remain in this state until all data has been written back. Then drop write
      // interest and declare read interest.
      if (count == remainingBytes) {
        context.nioBuffer.clear();
        key.cancel();
        if (context.terminating) {
          cleanup(socketChannel);
        } else {
          socketChannel.register(selector, SelectionKey.OP_READ);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
      cleanup(socketChannel);
    }
  }
}