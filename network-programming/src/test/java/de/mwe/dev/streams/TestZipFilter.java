package de.mwe.dev.streams;

import org.junit.jupiter.api.Test;

public class TestZipFilter {

  private static final String FILE_NAME_2_ZIP = "src/test/resources/fileToCreate.gz";

  @Test
  public void testZip(){
    GzipFilter gzp = new GzipFilter();

    gzp.zipData(FILE_NAME_2_ZIP);
    gzp.unzipData(FILE_NAME_2_ZIP);
  }
}
