/**
 * 
 */
package de.mwe.dev.design.patterns.solid.srp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mars
 * SRP: A class should have only a single reason to change. 
 * -> 1 primary responsibility per class
 * Anti-pattern: God-Object
 */
public class Journal {
	private final List<String> entries = new ArrayList<String>();
	private static int count = 0;
	
	public void addEntry(String text) {
		entries.add((++count) + ": " + text);
	}
	
	public void removeEntry(int idx) {
		entries.remove(idx);
	}
	
	@Override
	public String toString() {
		return String.join(System.lineSeparator(), entries);
	}
	
	@Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Journal other = (Journal) obj;
        if ((this.entries == null) ? (other.entries != null) : !this.entries.equals(other.entries)) {
            return false;
        }
        return true;
    }
}
