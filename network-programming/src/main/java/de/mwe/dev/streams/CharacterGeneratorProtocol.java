package de.mwe.dev.streams;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class CharacterGeneratorProtocol {

  private String filename;
  static private final Charset CHARSET = StandardCharsets.UTF_8;

  public CharacterGeneratorProtocol(String filename) {
    this.filename = filename;
  }

  public void writeFileByWriter() {
    try (FileWriter fw = new FileWriter(filename, CHARSET, true)) {
      generateProtocolByWriter(fw);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void writeFileByStream() {
    try (OutputStream out = new FileOutputStream(filename);
        OutputStream bufferedOut = new BufferedOutputStream(out)) {
      generateProtocolByStream(bufferedOut);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void generateProtocolByWriter(FileWriter fw) {
    byte[] byteSequence = generateCharSequence();

    String str = new String(byteSequence, CHARSET);
    char[] charSequence = str.toCharArray();
    try {
      fw.write(charSequence);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void generateProtocolByStream(OutputStream outStream) {
    byte[] byteSequence = generateCharSequence();

    try {
      outStream.write(byteSequence);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static byte[] generateCharSequence() {
    int startChar = 33;
    int endChar = 126;
    int numBytes = endChar - startChar;
    byte[] charSequence = new byte[numBytes + 3];
    for (int i = startChar; i <= endChar; i++) {
      charSequence[i - startChar] = (byte) i;
    }
    charSequence[numBytes + 1] = '\r';
    charSequence[numBytes + 2] = '\n';
    return charSequence;
  }
}
