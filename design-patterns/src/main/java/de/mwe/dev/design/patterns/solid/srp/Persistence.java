/**
 * 
 */
package de.mwe.dev.design.patterns.solid.srp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mars
 * 
 */
public class Persistence {

	public void save(Journal journal, String filename, boolean overwrite) throws FileNotFoundException {

		if (overwrite || new File(filename).exists()) {
			try (PrintStream out = new PrintStream(filename)) {
				out.println(journal.toString());
			}
		}
	}

	public Journal load(String filename) throws IOException {
		Journal j = new Journal();
		ClassLoader classLoader = getClass().getClassLoader();
		try (InputStream inputStream = classLoader.getResourceAsStream(filename);) {
			for(String entry : readFromInputStream(inputStream)) {
				j.addEntry(entry.substring(3));
			}
		}
		return j;
	}

	public Journal load(URL url) {
		// TODO: implement me
		return null;
	}

	private List<String> readFromInputStream(InputStream inputStream) throws IOException {
		List<String> results = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
			String line;
			while ((line = br.readLine()) != null) {
				results.add(line);
			}
		}		
		return results;
	}
	
	  
}
