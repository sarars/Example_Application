package main.java.com.application.java8.function;

import java.util.function.Function;

public class FunctionDemo1 {
	
	public static Double beforeJava8() {
		
		Integer usd = 10;
		Double inr = convertToINR(usd);
		return inr;
	}
	
	private static Double convertToINR(Integer usd) {
		
		Double initialINR = 71d;
		return  (usd * initialINR);
	}

	public static Double afterJava8() {
		
		Double initialINR = 71d;
		Function<Integer, Double> function = usd -> usd * initialINR;
		return function.apply(10);
	}
	
	public static void main(String... args) {
		
		System.out.println("Before Java 8 : " + beforeJava8());
		System.out.println("After Java 8 : " + afterJava8());
		
	}

}
