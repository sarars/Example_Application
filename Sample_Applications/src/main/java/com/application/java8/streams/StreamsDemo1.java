package main.java.com.application.java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsDemo1 {
	
	public static void main(String... args) {
		
		List<Integer> listOfNumbers = new ArrayList<>();
		listOfNumbers.add(5);
		listOfNumbers.add(10);
		listOfNumbers.add(15);
		listOfNumbers.add(20);
		listOfNumbers.add(25);
		withoutStreams(listOfNumbers);
		withStreams(listOfNumbers);
		
	}

	private static void withStreams(List<Integer> listOfNumbers) {
		
		List<Integer> evenListOfNumber = listOfNumbers
			.stream()
			.filter(even -> even % 2 == 0)
			.collect(Collectors.toList());
		System.out.println("With streams - Even numbers in the list");
		evenListOfNumber.forEach(System.out::println);
	}

	private static void withoutStreams(List<Integer> listOfNumbers) {

		List<Integer> evenListOfNumber = new ArrayList<>();
		for (int num : listOfNumbers) {
			if (num % 2 == 0) {
				evenListOfNumber.add(num);
			}
		}
		System.out.println("Without streams - Even numbers in the list");
		for(int even : evenListOfNumber) {
			System.out.println(even);
		}
	}

}
