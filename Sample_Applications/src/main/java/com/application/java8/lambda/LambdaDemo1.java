package main.java.com.application.java8.lambda;

interface DefaultInterface{
	public int addTwoNumbers(int a, int b);
}


public class LambdaDemo1 {
	

	public static void main(String... args) {
		
		// Example 1
		/***
		 * Lambda expression can be used for implementing a functional interface 
		 * ie an interface with just 1 method.
		 */
		DefaultInterface defaultInterface1 = (a,b) -> a+b;
		System.out.println("Sum of two numbers using Lambda expression from Java 8");
		System.out.println(defaultInterface1.addTwoNumbers(10, 20));
		
		// Example 2 
		/***
		 * Multi-line lambda defintions require curly braces and return keyword
		 */
		DefaultInterface defaultInterface2 = (a,b) -> {
			System.out.println("Multiline interfaces");
			return a+b;
		};
		System.out.println("Example 2");
		System.out.println(defaultInterface2.addTwoNumbers(30, 40));
	}
}
