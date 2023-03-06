package de.mwe.dev.streams;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GzipFilter {

  public void zipData(String filename) {
    try (OutputStream out = new FileOutputStream(filename);
        OutputStream bufferedOut = new BufferedOutputStream(out);
        OutputStream gzip = new GZIPOutputStream(out);) {
      byte[] data = CharacterGeneratorProtocol.generateCharSequence();
      gzip.write(data);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void unzipData(String filename) {
    try (InputStream in = new FileInputStream(filename);
        InputStream bufferedIn = new BufferedInputStream(in);
        InputStream gzipIn = new GZIPInputStream(bufferedIn)) {
      byte[] data = gzipIn.readAllBytes();
      char[] charData = new char[data.length];
      for (int i = 0; i < data.length; i++) {
        charData[i] = (char) data[i];
      }
      System.out.println("unzipped data:\n" + String.valueOf(charData));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
