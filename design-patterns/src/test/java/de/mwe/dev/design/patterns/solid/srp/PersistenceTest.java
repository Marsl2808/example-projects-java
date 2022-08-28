/**
 * 
 */
package de.mwe.dev.design.patterns.solid.srp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.URL;

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
		String filename = url.getPath() + "journal.txt";
		p.save(j, filename, true);
		
		Journal jLoad = p.load("journal.txt");
		
		assertEquals(j.toString().substring(3), jLoad.toString().substring(3));		
	}
}
