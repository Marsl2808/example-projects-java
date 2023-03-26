/**
 * 
 */
package de.mwe.dev.dpatterns.solid.srp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mars
 * 
 */
public class Persistence {

    /**
     * Save Journal to FS using plattform encoding (via Stream-API).
     * @param journal
     * @param filename
     * @param overwrite
     * @throws FileNotFoundException
     */
    public void save(Journal journal, String filename, boolean overwrite) throws FileNotFoundException {
        if (overwrite || new File(filename).exists()) {
            try (PrintStream out = new PrintStream(filename)) {
                out.println(journal.toString());
            }
        }
  }
  
  /**
   * Save journal to FS using specified encoding (via Writer-API).
   * @param journal
   * @param filename
   * @param overwrite
   * @throws IOException 
   */
  public void save(Journal journal, String filename, boolean overwrite, Charset charset) throws IOException {
    if (overwrite || new File(filename).exists()) {
      try (PrintWriter out = new PrintWriter(filename, charset)) {
        out.println(journal.toString());
      }
    }
  }
  
  /**
   * Read Journal from FS using specified encoding (via Reader-API).
   * @param filename
   * @param charset
   * @return
   * @throws IOException
   */
  public Journal read(String filename, Charset charset) throws IOException {
    Journal j = new Journal();
    Reader reader = new InputStreamReader(new FileInputStream(filename), charset);
    for(String entry : readLine(reader)) {
      j.addEntry(entry.substring(3));
    }
    return j;
  }

  /**
   * Read Journal from FS using default plattform encoding (via Reader-API).
   * @param filename
   * @return
   * @throws IOException
   */
  public Journal read(String filename) throws IOException {
    Journal j = new Journal();
    Reader reader = new InputStreamReader(new FileInputStream(filename));
    for(String entry : readLine(reader)) {
      j.addEntry(entry.substring(3));
    }
    return j;
  }

  /**
   * Helper fct. for buffered reading of a line. 
   * @param myReader
   * @return
   * @throws IOException
   */
  private List<String> readLine(Reader myReader) throws IOException {
    List<String> results = new ArrayList<String>();
    try (BufferedReader br = new BufferedReader(myReader)) {
      String line;
      while ((line = br.readLine()) != null) {
        results.add(line);
      }
    }		
    return results;
  }

  public Journal load(URL url) {
    System.out.println("Load journal from url...\n(not implemented yet)");
    return null;
  }
}
