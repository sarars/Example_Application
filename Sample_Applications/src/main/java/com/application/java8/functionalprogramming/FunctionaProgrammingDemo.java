package main.java.com.application.java8.functionalprogramming;

@FunctionalInterface
interface FunctionalProgrammingInterface{
	int sumOfTwoNumbers(int a, int b);
}

public class FunctionaProgrammingDemo {
	
	
	public void addTwoNumbers(FunctionalProgrammingInterface functionalProgrammingInterface) {
		System.out.println("Sum of two numbers" + functionalProgrammingInterface.sumOfTwoNumbers(20, 10));
	}
	
	public static void main(String... args) {
		FunctionaProgrammingDemo functionaProgrammingDemo = new FunctionaProgrammingDemo();
		
		FunctionalProgrammingInterface functionalProgrammingInterface = (a,b) -> a+b;
		
		functionaProgrammingDemo.addTwoNumbers(functionalProgrammingInterface);
	}

}
