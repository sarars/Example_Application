package main.java.com.application.java8.forEach;

import java.util.Arrays;
import java.util.List;

public class ForEachDemo {

	public static void main(String... args) {

	List<Integer> listOfNumbers = Arrays.asList(1,2,3,4,5);	
	withoutForEach(listOfNumbers);
	withForEach(listOfNumbers);
		
	}

	private static void withForEach(List<Integer> listOfNumbers) {
		
		System.out.println("With forEach - 1");
		listOfNumbers.forEach(System.out::println);
		
		System.out.println("With forEach - 2");
		listOfNumbers.forEach(x -> System.out.println(x));
	}

	private static void withoutForEach(List<Integer> listOfNumbers) {
		
		System.out.println("Without forEach");
		for( int i : listOfNumbers ) {
			System.out.println(i);
		}
	}

}
