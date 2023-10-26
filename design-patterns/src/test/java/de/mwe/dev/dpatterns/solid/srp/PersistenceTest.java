/**
 * 
 */
package de.mwe.dev.dpatterns.solid.srp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;

/**
 * @author mars
 *
 */
class PersistenceTest {

  @Test
  void test() throws IOException, InterruptedException {
    Journal j = new Journal();
    j.addEntry("my private thoughts of yesterday");

    Persistence p = new Persistence();

    URL url = Thread.currentThread().getContextClassLoader().getResource("");
    String fqFilename = url.getPath() + "journalDefault.txt";
    p.save(j, fqFilename, true);

    Journal jLoad = p.read(fqFilename);

    assertEquals(j.toString().substring(3), jLoad.toString().substring(3));		
  }

  @Test
  void testSpecifiedCharsetWrite() throws IOException {
    Journal journal = new Journal();
    journal.addEntry("my private thoughts of today");

    Persistence p = new Persistence();

    URL url = Thread.currentThread().getContextClassLoader().getResource("");
    String fqFilename = url.getPath() + "journalAscii.txt";
    Charset myCharset = StandardCharsets.US_ASCII;
    p.save(journal, fqFilename, true, myCharset);

    assertNotNull(p.read(fqFilename, myCharset));
  }
}
