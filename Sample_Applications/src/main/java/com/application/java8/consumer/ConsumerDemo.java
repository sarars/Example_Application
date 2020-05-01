package main.java.com.application.java8.consumer;

import java.util.function.Consumer;

public class ConsumerDemo {
	
	public static void main(String... args) {
		
		String java = "Java";
		beforeJava8(java);
		afterJava8(java);
	}

	private static void afterJava8(String java) {
		Consumer<String> consumer = c -> System.out.println(c);
		consumer.accept(java);
	}

	private static void beforeJava8(String java) {
		
		print(java);
		
	}

	private static void print(String java) {
		System.out.println(java);
	}

}
