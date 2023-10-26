/**
 * 
 */
package de.mwe.dev.dpatterns.solid.isp;

/**
 * @author mars
 * isp supports YAGNI, otherwise additional impl of fax/scan required
 */
public class OldFashionedPrinter implements Printer{

  @Override
  public void print(Document d) {
    System.out.println("Printing document...\n(not implemented yet)");
  }
}
