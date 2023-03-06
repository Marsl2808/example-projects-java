package de.mwe.dev.streams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ProtocolFileReader {

  public static final String FILE_NAME = "src/test/resources/fileToCreate.txt";
  public static final Charset CHARSET = StandardCharsets.UTF_8;

  public void readFileByReader() {
    try(FileReader fr = new FileReader(FILE_NAME, CHARSET);
    BufferedReader br = new BufferedReader(fr)){
    printFile(br);
    }catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void printFile(BufferedReader br) throws IOException {
    while(true){
      String line = br.readLine();
      if(line == null)
        break;
      System.out.println(line);
    }
  }

  public void readFileByStream(){
    ClassLoader classloader = Thread.currentThread().getContextClassLoader();
    try(InputStream in = classloader.getResourceAsStream("fileToCreate.txt");
      BufferedReader br = new BufferedReader(new InputStreamReader(in))){
        printFile(br);
    }catch(IOException e){
      e.printStackTrace();
    }
  }
}
