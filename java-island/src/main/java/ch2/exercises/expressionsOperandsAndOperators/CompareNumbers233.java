/**
 * 
 */
package ch2.exercises.expressionsOperandsAndOperators;

import java.util.Scanner;

/**
 * @author Mars
 * Task 2.3.3, page 44
 */
public class CompareNumbers233 {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Erste Zahl Eingeben:");
		int number1 = scanner.nextInt();
		System.out.println("Zweite Zahl eingeben:");
		int number2 = scanner.nextInt();
		
		// format input
		String sNumber1 = String.valueOf(number1);
		String sNumber2 = String.valueOf(number2);
		if(sNumber1.length() > 2) {
			sNumber1 = sNumber1.substring(sNumber1.length()-2);
		}
		if(sNumber2.length() > 2) {
			sNumber2 = sNumber2.substring(sNumber2.length()-2);
		}
		if(sNumber1.length() == 1) {
			sNumber1 = "0" + sNumber1;
		}
		if(sNumber2.length() == 1) {
			sNumber2 = "0" + sNumber2;
		}
		
		// compare numbers
		boolean sameNumber = sNumber2.contains(String.valueOf(sNumber1.charAt(0))) || sNumber2.contains(String.valueOf(sNumber1.charAt(1)));
		System.out.println(sameNumber);
		
	}

}
