package main.java.com.application.java8.mapFlatMap;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapAndFlatMapDemo {

	public static void main(String... args) {
		
		List<String> stringList = new ArrayList<>();
		stringList.add("Java 7");
		stringList.add("Java 8");
		stringList.add("Java 9");
		stringList.add("Java 10");
		stringList.add("Java 11");
		stringList.add("Java 12");
		stringList.add("Java 13");
		withMap(stringList);
		withFlatMap(stringList);
	}

	private static void withFlatMap(List<String> stringList) {
		
		List<String> newStringList = stringList
			.stream()
			.flatMap(stringWord -> Stream.of(stringWord.toUpperCase(),
					stringWord.toLowerCase(),
					stringWord.concat(" Coding")))
			.collect(Collectors.toList());
		System.out.println("With flatMap()" + newStringList);
		//newStringList.forEach(System.out::println);
	}

	private static void withMap(List<String> stringList) {
		
		List<String> upperCaseList = stringList.stream().map(string -> string.toUpperCase()).collect(Collectors.toList());
		System.out.println("With map()" + upperCaseList);
		//upperCaseList.forEach(System.out::println);
	}

}
