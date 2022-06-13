/**
 * 
 */
package ch2.exercises.caseConditions;

import java.util.Scanner;

/**
 * @author Mars
 * task 2.4.2, page 47
 */
public class PayDay241 {

	public static void main(String[] args) {
		
		double purchasePrice = 1000.0;
		double minPriceRel = .1 * purchasePrice;
		double maxPriceRel = .2 * purchasePrice;
		
		System.out.println("Payment:");
		Scanner scanner = new Scanner(System.in);
		double repayment = scanner.nextDouble();
		
		double diff = repayment - purchasePrice;
			
		if(diff < minPriceRel || diff > maxPriceRel ) {
			System.out.println("You Son of a b***!");
		}else {
			System.out.println("Good boy!");
		}
		
		scanner.close();
	}
}
