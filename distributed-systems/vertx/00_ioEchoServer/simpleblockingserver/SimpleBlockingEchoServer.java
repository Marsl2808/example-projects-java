package simpleblockingserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * SimpleBlockingEchoServer spawns a thread for each incoming connection
 * Threads may block for r/w
 * 
 * SimpleClient:
 * netstat (nc) localhost 3000
 */
public class SimpleBlockingEchoServer {

  public static void main(String[] args) {
    try {
      ServerSocket serverSocket = new ServerSocket();
      serverSocket.bind(new InetSocketAddress(3000));
      while(true){
        Socket socket = serverSocket.accept();
        new Thread(clientHandler(socket)).start();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static Runnable clientHandler(Socket socket){
    return () -> {
      // Socket Object delivers Input-/Outputstreams for data exchange
      try(BufferedReader reader = new BufferedReader((
          new InputStreamReader(socket.getInputStream())));
        PrintWriter writer = new PrintWriter(
          new OutputStreamWriter(socket.getOutputStream()))){
        String line = "";
        while(!"/quit".equals(line)){
          // blocking (1):
          line = reader.readLine();
          System.out.println("~ " + line);
          // blocking (2)
          writer.write(line + "\n");
          writer.flush();
        }
        }catch(IOException e){
      e.printStackTrace();
    }
    };
  }
}
