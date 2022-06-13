package ch2.exercises.expressionsOperandsAndOperators;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
* task 2.3.2, page 43
*/
public class Loot232 {

	private static Logger logger = LoggerFactory.getLogger(Loot232.class);
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		logger.info("Number of bottles in total:");
		
		Scanner scanner = new java.util.Scanner(System.in);
		int numBottles = scanner.nextInt();
		
		int numBottlesCaptain;
		int numBottlesCrew;
		if(numBottles % 2 != 0) {
			numBottlesCaptain = numBottles/2;
			numBottlesCrew = numBottles - numBottlesCaptain;
		}else {
			numBottlesCaptain = numBottles/2;
			numBottlesCrew = numBottlesCaptain;
		}
		logger.info("Bottles for the captain:" + String.valueOf(numBottlesCaptain));
		logger.info("Bottles for the crew:" + String.valueOf(numBottlesCrew));
		logger.info("Number of crew members: ");
		int numCrewMembers = scanner.nextInt();
		if(numBottlesCrew % numCrewMembers == 0) {
			logger.info("Fair share without remainder? " + "YES");
		}else {
			logger.info("Fair share without remainder? " + "NO");
		}
	}
}
