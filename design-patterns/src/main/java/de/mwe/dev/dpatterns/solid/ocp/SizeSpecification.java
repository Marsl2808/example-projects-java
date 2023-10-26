/**
 * 
 */
package de.mwe.dev.dpatterns.solid.ocp;

/**
 * @author mars
 *
 */
public class SizeSpecification implements Specification<Product> {

  private Size size;
  
  public SizeSpecification(Size size) {
    this.size = size;
  }
  @Override
  public boolean isSatisfied(Product item) {
    return item.size == size;
  }

}
