/**
 * 
 */
package de.mwe.dev.dpatterns.solid.ocp;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author mars
 *
 */
public interface Filter<T> {
  Stream<T> filter(List<T> items, Specification<T> spec);
}
