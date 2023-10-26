/**
 * 
 */
package de.mwe.dev.dpatterns.solid.lsp;

/**
 * @author mars
 * Better Solution, no explicit Square class needed
 */
public class RectangleFactory {

  public static Rectangle newRectangle(int width,int height) {
    return new Rectangle(width, height);
  }
  
  public static Rectangle newSquare(int side) {
    return new Rectangle(side, side);
  }	
}
