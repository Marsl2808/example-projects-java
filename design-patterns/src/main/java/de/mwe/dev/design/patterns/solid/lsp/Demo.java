/**
 * 
 */
package de.mwe.dev.design.patterns.solid.lsp;

/**
 * @author mars
 * violation of LSP will result in incorrect code through inheritance
 */
public class Demo {
	
	static void useIt(Rectangle r) {
		int width = r.getWidth();
		r.setHeight(10);
		// area = width * 10 -> setter violates lsp!
		// -> method only works for rectangle, not for square
		// Solution: method isSquare() to Square class, or alternatively factory pattern 
		//           for object creation
		
		System.out.println("Expected area of " + (width * 10) +
				", got " + r.getArea());
	}
	
	public static void main(String... args) {
		Rectangle rc = new Rectangle(2,3);
		useIt(rc);
		Square sq = new Square(5);
		useIt(sq);
	}
}
