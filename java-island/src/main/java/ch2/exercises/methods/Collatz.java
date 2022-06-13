package ch2.exercises.methods;

public class Collatz {
	
	Collatz(){
		collatz(7l);
	}

	
	long collatz(long n) {
		String rightArrow = " \u2794 "; 
		System.out.print(n + rightArrow);
		while (n > 1l) {
			n = (n%2 == 0) ? n/2 : 3*n + 1l;
			System.out.print(n + ((n == 1) ? "" : rightArrow));
		}
		return n;	
	}
	
	public static void main(String[] args) {
		new Collatz();
	}

}
