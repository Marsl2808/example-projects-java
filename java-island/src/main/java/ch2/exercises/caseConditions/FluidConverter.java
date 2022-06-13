/**
 * 
 */
package ch2.exercises.caseConditions;

import java.util.Scanner;

/**
 * @author Mars
 * task 2.4.3, page 47 + 48
 */
public class FluidConverter {

	public static void main(String[] args) {
		
		System.out.println("Enter quantity in liters:");
		try(Scanner scanner = new Scanner(System.in)) {
			double fluidInLiter = scanner.nextDouble();
			
			if(fluidInLiter >= 1.0)
				System.out.println("ca. " + (int)fluidInLiter + " l" );
			else if(fluidInLiter >= .1)
				System.out.println("ca. " + (int)(fluidInLiter * 100) + " cl");
			else 
				System.out.println("ca. " + (int)(fluidInLiter * 1000) + " ml");
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
