/**
 * 
 */
package ch2.exercises.expressionsOperandsAndOperators;

/**
 * @author Mars
 * task 2.3.5, page 45
 */
public class NoBottles235 {

	public static void main(String[] args) {
		int noBottles = 0;
		String out = noBottles + ((noBottles != 1) ? " bottles " : " bottle ");
		System.out.println( out + "of rum");
	}

}
