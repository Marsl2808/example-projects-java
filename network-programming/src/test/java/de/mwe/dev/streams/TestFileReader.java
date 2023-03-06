package de.mwe.dev.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestFileReader {

  @BeforeAll
  public static void checkIfFileExists(){
    if(!Files.exists(Paths.get(ProtocolFileReader.FILE_NAME)))
      try{
        Files.createFile(Paths.get(ProtocolFileReader.FILE_NAME));
      }catch(IOException e){
        e.printStackTrace();
      }
  }

  @Test
  public void readFile(){
    ProtocolFileReader pfr = new ProtocolFileReader();
    pfr.readFileByReader();
    // works only if file exists at startup (e.g. 2. Testrun)
    // pfr.readFileByStream();
  }
}
