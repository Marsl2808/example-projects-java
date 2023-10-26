/**
 * 
 */
package de.mwe.dev.dpatterns.solid.ocp;

/**
 * @author mars
 * OCP + Specification Pattern (not contained in GO4)
 */
public class Product {
  
  public String name;
  public Color color;
  public Size size;
  
  public Product(String name, Color color, Size size) {
    this.name = name;
    this.color = color;
    this.size = size;
  }
}
