/**
 * 
 */
package de.mwe.dev.dpatterns.solid.isp;

/**
 * @author mars
 *
 */
public class MultifunctionPrinter implements Machine {

  @Override
  public void print(Document d) {
    System.out.println("Printing document...\n(not implemented yet)");
  }

  @Override
  public void fax(Document d) {
    System.out.println("Send document by Fax...\n(not implemented yet)");
  }

  @Override
  public void scan(Document d) {
    System.out.println("Scanning document...\n(not implemented yet)");
  }
}
