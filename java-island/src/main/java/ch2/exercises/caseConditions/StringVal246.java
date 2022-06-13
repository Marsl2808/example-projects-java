/**
 * 
 */
package ch2.exercises.caseConditions;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Mars
 * task 2.4.6, page 49
 */
public class StringVal246 {

	public static void main(String[] args) {
		String[] cpr = {"Ay", "Ay, ay", "Ein Ei", "yes", "ja"};
		Scanner scanner = new Scanner(System.in);
		
		String input = scanner.nextLine();
		
		if(Arrays.asList(cpr).contains(input))
			System.out.println("Keep it up!");
		else
			System.out.println("Don't you dare!");
		
		scanner.close();
	}

}
