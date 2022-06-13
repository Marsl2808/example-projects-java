package ch2.exercises.methods;

public class RightTriangle {

	RightTriangle(){
		System.out.println(isRightTriangle(5.0,4.0,3.0));
	}
	
	private boolean isRightTriangle(double x, double y, double z) {
		// largest to c
		double c = Math.max(Math.max(x,y),z);
		double a = (x == z) ? z : x;
		double b = (y == z) ? z : y;

		return  Math.pow(c,2) - (Math.pow(a,2) + Math.pow(b,2)) <= 0.000001;
	}

	public static void main(String[] args) {
		new RightTriangle();
	}

}
