/**
 * 
 */
package de.mwe.dev.dpatterns.solid.ocp;

import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * @author mars
 *
 */
class ProductTest {

  @Test
  void testProductFilterNoOcp() {
    List<Product> products = getTestProducts();

    ProductFilter pf = new ProductFilter();
    System.out.println("Green products (no ocp):");
    pf.filterByColor(products, Color.GREEN).forEach(p -> System.out.println(" - " + p.name + " is green"));
  }

  @Test
  void testProductFilterOcp() {
    List<Product> products = getTestProducts();
    BetterFilter bf = new BetterFilter();
    System.out.println("Green products (ocp, specification pattern):");
    bf.filter(products, new ColorSpecification(Color.GREEN))
        .forEach(p -> System.out.println(" - " + p.name + " is green"));

    System.out.println("Large Blue products (ocp, AND-Specification):");
    bf.filter(products,
        new AndSpecification<>(new ColorSpecification(Color.BLUE), new SizeSpecification(Size.LARGE)))
        .forEach(p -> System.out.println(" - " + p.name + " is blue and large"));
  }

  private List<Product> getTestProducts() {
    Product apple = new Product("Apple", Color.GREEN, Size.SMALL);
    Product tree = new Product("Tree", Color.GREEN, Size.SMALL);
    Product house = new Product("House", Color.BLUE, Size.LARGE);

    List<Product> products = List.of(apple, tree, house);
    return products;
  }
}
