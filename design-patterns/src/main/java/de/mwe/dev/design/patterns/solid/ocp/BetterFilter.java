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
public class BetterFilter implements Filter<Product> {

	@Override
	public Stream<Product> filter(List<Product> items, Specification<Product> spec) {
		return items.stream().filter(p -> spec.isSatisfied(p));
	}
}
