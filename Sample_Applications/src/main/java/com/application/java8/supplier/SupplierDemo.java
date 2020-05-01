package main.java.com.application.java8.supplier;

import java.util.function.Supplier;

public class SupplierDemo {
	
	public static void main(String... args) {
		beforeJava8();
		afterJava8();
	
	}

	private static void beforeJava8() {
		
		double initialINR = 71;
		getUSDValue(initialINR);
	}

	private static void getUSDValue(double initialINR) {
		System.out.println("1 USD is : " + initialINR);
	}

	private static void afterJava8() {
		
		double initialINR = 71;
		Supplier<Double> supplier = () -> initialINR;
		System.out.println("1 USD is : " + supplier.get());
	}
	
}
