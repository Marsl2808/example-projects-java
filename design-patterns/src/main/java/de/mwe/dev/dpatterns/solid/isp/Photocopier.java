/**
 * 
 */
package de.mwe.dev.dpatterns.solid.isp;

/**
 * @author mars
 * alternative: decorator pattern (s. class MultifunctionDevice)
 */
public class Photocopier implements Scanner, Printer {

  @Override
  public void print(Document d) {
    System.out.println("Printing document...\n(not implemented yet)");
  }

  @Override
  public void scan(Document d) {
    System.out.println("Scanning document...\n(not implemented yet)");
  }
}
