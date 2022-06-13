package ch2.exercises.methods;

import java.util.Arrays;

public class LinePrinter {
	
	LinePrinter(){
		printHearts();
	}
	
	private void printHearts() {
		String heartUnicode = "\u2764";
		String[] hearts = new String[10];
		Arrays.fill(hearts, heartUnicode);
		Arrays.asList(hearts).forEach(System.out::print);
	}
	
	

	public static void main(String[] args) {
		new LinePrinter();
	}

}
