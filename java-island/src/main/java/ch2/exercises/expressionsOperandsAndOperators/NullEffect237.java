/**
 * 
 */
package ch2.exercises.expressionsOperandsAndOperators;

/**
 * @author Mars
 * task 2.3.7, page 46
 */
public class NullEffect237 {

	public static void main(String[] args) {
		
		int zero = 0;
		double anotherZero = 0;
		int ten = 10;
		double anotherTen = 10;
		
		System.out.println(anotherTen / zero);
		System.out.println(ten / anotherZero);
		System.out.println(ten / zero);

	}

}
