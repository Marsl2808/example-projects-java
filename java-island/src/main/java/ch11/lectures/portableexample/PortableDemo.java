/**
 * 
 */
package ch11.lectures.portableexample;

import java.util.Arrays;

/**
 * @author Mars
 *
 */
public class PortableDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Pen pen = new Pen();
		pen.setWeight(10);
		
		Cup cup1 = new Cup();
		cup1.setWeight(100);
		
		Cup cup2 = new Cup();
		cup2.setWeight(300);	
		
		System.out.println(PortableUtils.areLighterThan(Arrays.asList(pen, cup1), 10));
		System.out.println(PortableUtils.areLighterThan(Arrays.asList(pen, cup1), 120));
	}
}
