/**
 * 
 */
package de.mwe.dev.dpatterns.solid.ocp;

/**
 * @author mars
 *
 */
public interface Specification<T> {
  boolean isSatisfied(T item);
}
