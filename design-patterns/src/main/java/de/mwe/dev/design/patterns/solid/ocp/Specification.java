/**
 * 
 */
package de.mwe.dev.design.patterns.solid.ocp;

/**
 * @author mars
 *
 */
public interface Specification<T> {
	boolean isSatisfied(T item);
}
