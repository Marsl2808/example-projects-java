/**
 * 
 */
package de.mwe.dev.dpatterns.solid.isp;

/**
 * @author mars
 * example of decorator pattern
 */
public class MultifunctionMachine implements MultifunctionDevice {

  private Printer printer;
  private Scanner scanner;
  
  
  public MultifunctionMachine(Printer printer, Scanner scanner) {
    super();
    this.printer = printer;
    this.scanner = scanner;
  }

  @Override
  public void print(Document d) {
    printer.print(d);
  }

  @Override
  public void scan(Document d) {
    scanner.scan(d);
  }
}
