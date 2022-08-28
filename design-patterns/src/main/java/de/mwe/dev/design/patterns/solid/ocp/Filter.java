/**
 * 
 */
package de.mwe.dev.design.patterns.solid.ocp;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author mars
 *
 */
public interface Filter<T> {
	Stream<T> filter(List<T> items, Specification<T> spec);
}
