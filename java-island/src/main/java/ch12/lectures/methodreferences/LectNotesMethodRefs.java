package ch12.lectures.methodreferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch2.exercises.expressionsOperandsAndOperators.Loot232;

public class LectNotesMethodRefs {

	private static Logger logger = LoggerFactory.getLogger(Loot232.class);

	LectNotesMethodRefs(){
		///////////////////////////////////////////////////
		// 1) Method reference on static method
		///////////////////////////////////////////////////
		// implementation of (functional) methods can be delegated
		// 1.1) with params
		Consumer<String> out = System.out::println;
		out.accept("Hello Consumer!");

		// 1.2) without params
		Runnable outR = System.out::println;
		outR.run();

		///////////////////////////////////////////////////
		// 2) object method
		///////////////////////////////////////////////////
		Predicate<String> pred = String::isEmpty;
		logger.info("Predicate test: " + pred.test(""));

		logger.info(trimCompare("test", " test  ") == 0 ? "strings are equal (trimmed)" : "Strings are not equal");
		String[] words = {"testB", "testA "};
		Arrays.sort(words, this::trimCompare);
		logger.info(Arrays.toString(words));

		////////////////////////////////////////////////////
		// 2) java.util.function
		////////////////////////////////////////////////////
		// 2.1) Consumer
		logger.info("Consumer Test: ");
		Arrays.asList(1,2,3,4).forEach(System.out::println);
		
		// 2.2) Predicate
		Predicate<Character> isDigit = c -> Character.isDigit(c); // Character::isDigit
		logger.info("Predicate Test: " + isDigit.test('a'));
		// example: 
		deleteNonNumbersFromList();
		
		

	}

	private void deleteNonNumbersFromList() {
		Predicate<Character> isDigit = Character::isDigit;
		List<Character> list = new ArrayList<>(Arrays.asList('1','2','a','b'));
		list.removeIf(isDigit);
		
	}

	private int trimCompare(String s1,String s2) {
		return s1.trim().compareTo(s2.trim());
	}

	public static void main(String[] args) {
		new LectNotesMethodRefs();
	}

}
