/**
 * 
 */
package ch2.exercises.expressionsOperandsAndOperators;

import java.util.Scanner;

/**
 * @author Mars
 * task 2.3.4, page 44
 */
public class CoinMachine234 {

	public static void main(String[] args) {
		
		System.out.println("please give in amount of money as float: ");
		Scanner scanner = new Scanner(System.in);
		int amountInCents = (int)(scanner.nextFloat() * 100);

		System.out.println(amountInCents / 200 +  " x 2€");
		amountInCents %= 200;

		System.out.println(amountInCents / 100 + " x 1€");
		amountInCents %= 100;
		
		System.out.println(amountInCents / 50 + " x 50 ct");
		amountInCents %= 50;
		
		System.out.println(amountInCents / 20 + " x 20 ct");
		amountInCents %= 20;
		
		System.out.println(amountInCents / 10 + " x 10 ct");
		amountInCents %= 10;
		
		System.out.println(amountInCents / 5 + " x 5 ct");
		amountInCents %= 5;
		
		System.out.println(amountInCents / 2 + " x 2 ct");
		amountInCents %= 2;
		
		System.out.println(amountInCents + " x 1 ct");

		scanner.close();


	}
}
