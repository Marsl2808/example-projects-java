/**
 * 
 */
package ch2.exercises.expressionsOperandsAndOperators;
import static java.lang.Math.abs;

/**
 * @author Mars
 * task 2.3.6, page 46
 */
public class TwentyOne236 {

	public static void main(String[] args) {
		int dealer = 22;
		int player = 23;
		int result = 0;	
		
		if(!(dealer > 21 & player > 21)) {
			if(!(dealer < 14) & !(player < 14))
				result = abs(dealer - 21) < abs(player - 21) ? dealer : player;
			else {
				System.out.println("Invalid Input");
			    System.exit(0);
			}
			if(dealer > 21)
				result = player;
			if(player > 21)
				result = dealer;
		}
		System.out.println(result);	
	}
}

