package main.java.com.application.java8.function;

import java.util.function.Function;

public class FunctionDemo2 {
	
	public static void main(String... args) {
		
		// Example 1
		Function<Integer, Integer> function1 = a -> a + a;
		Function<Integer, Integer> function2 = a -> a * a;
		
		System.out.println(function1.andThen(function2).apply(10));
		
		// Example 2
		Function<String, String> function3 = a -> a.toUpperCase();
		Function<String, String> function4 = a -> a + "World";
		System.out.println(function3.andThen(function4).apply("Hello"));
		
		// Example 3
		Function<Integer, Integer> function5 = a -> a + a;
		Function<Integer, Integer> function6 = a -> a * a;;
		System.out.println(function5.compose(function6).apply(10));
		
		// Example 4
		Function<String, String> function7 = a -> a.toUpperCase();
		Function<String, String> function8 = a -> a + "World";
		System.out.println(function7.compose(function8).apply("Hello"));
		
		// Exxample 5
		Function<Integer, Integer> function9 = Function.identity();
		System.out.println(function9.apply(10));
		
		// Example 5
		Function<String, String> function10 = Function.identity();
		System.out.println(function10.apply("Hello"));	
		
		// Example 5
		Function<Boolean, Boolean> function11 = Function.identity();
		System.out.println(function11.apply(true));
				
					
				
		
	}

}
