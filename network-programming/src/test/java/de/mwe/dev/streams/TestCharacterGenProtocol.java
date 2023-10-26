package de.mwe.dev.streams;

import org.junit.jupiter.api.Test;

public class TestCharacterGenProtocol {

  private static final String FILE_NAME = "src/test/resources/fileToCreate.txt";

  @Test
  public void testGenerator(){
    CharacterGeneratorProtocol cgp = new CharacterGeneratorProtocol(FILE_NAME);

    // 1) Write File by Stream (default charset)
    cgp.writeFileByStream();

    // 2) Write File by Writer
    cgp.writeFileByWriter();
  }
}
