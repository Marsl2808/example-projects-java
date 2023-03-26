/**
 * 
 */
package de.mwe.dev.dpatterns.solid.ocp;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author mars
 * Better Filter implementation using specification pattern. 
 * New Specifications are implemented by implementing the Specification interface.
 * By adding a new filter BetterFilter class doesnt change.
 */
public class BetterFilter implements Filter<Product> {

  @Override
  public Stream<Product> filter(List<Product> items, Specification<Product> spec) {
    return items.stream().filter(p -> spec.isSatisfied(p));
  }
}
