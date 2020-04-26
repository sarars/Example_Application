package main.java.com.application.java8.defaultMethod;

interface DefaultInterface{
	default public int addTwoNumbers(int a, int b) {
		return a+b;
	}
}


public class DefaultMethodDemo1 {
	
	class Class1 implements DefaultInterface{
	}

	class Class2 implements DefaultInterface{
	}
	class Class3 implements DefaultInterface{
		
	}
	
	public static void main(String... args) {
		
		DefaultMethodDemo1 defaultMethodDemo1 = new DefaultMethodDemo1();
		
		Class1 class1 = defaultMethodDemo1.new Class1();
		System.out.println("Sum of 10 and 20");
		class1.addTwoNumbers(10, 20);
		
		Class2 class2 = defaultMethodDemo1.new Class2();
		System.out.println("Sum of 30 and 40");
		class2.addTwoNumbers(30, 40);
		
	}

}
