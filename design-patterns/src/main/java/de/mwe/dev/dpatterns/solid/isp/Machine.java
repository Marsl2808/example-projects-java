/**
 * 
 */
package de.mwe.dev.dpatterns.solid.isp;

/**
 * @author mars
 * Better Solution: split functionality in seperate interfaces, s.t. developers
 * don't need to implement unnecessary functionality
 */
public interface Machine {

  void print(Document d);
  void fax(Document d);
  void scan(Document d);
}
