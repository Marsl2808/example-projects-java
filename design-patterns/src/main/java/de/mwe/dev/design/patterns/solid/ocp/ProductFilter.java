/**
 * 
 */
package de.mwe.dev.design.patterns.solid.ocp;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author mars
 * Example of no-ocp, a new filter has to be added to the class.
 */
public class ProductFilter {

	public Stream<Product> filterByColor(List<Product> products, Color color){
		return products.stream().filter(p -> p.color == color);
	}
	
	public Stream<Product> filterBySize(List<Product> products, Size size){
		return products.stream().filter(p -> p.size == size);
	}
	
	public Stream<Product> filterByColorSize(List<Product> products, Size size, Color color){
		return products.stream().filter(p -> p.size == size && p.color == color);
	}
}
