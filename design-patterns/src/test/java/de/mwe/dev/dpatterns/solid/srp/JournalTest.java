/**
 * 
 */
package de.mwe.dev.dpatterns.solid.srp;

import org.junit.jupiter.api.Test;
/**
 * @author mars
 *
 */
class JournalTest {

	@Test
	void testJournal() {
		Journal j = new Journal();
		j.addEntry("my private thoughts of yesterday");
		j.addEntry("my private thoughts of today");
		j.addEntry("my private thoughts of tomorrow");
		
		System.out.println(j);
	}
}
