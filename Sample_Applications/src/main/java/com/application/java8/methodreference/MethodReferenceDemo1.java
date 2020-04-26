package main.java.com.application.java8.methodreference;

@FunctionalInterface
interface MethodReferenceInterface{
	void helloMethodReference(); 
}

public class MethodReferenceDemo1 {
	
	// static method
	public static void helloMethodReference() {
		System.out.println("In static hello method reference method");
	}
	
	public void helloMethodReference1() {
		System.out.println("In non-static hello method reference method");
	}
	
	public static void main(String... args) {
		
		// Using Double colon, method reference
		MethodReferenceInterface methodReferenceInterface1 = MethodReferenceDemo1::helloMethodReference;
		methodReferenceInterface1.helloMethodReference();
		
		//Using lambda expression
		MethodReferenceInterface methodReferenceInterface2 = () -> MethodReferenceDemo1.helloMethodReference();
		methodReferenceInterface2.helloMethodReference();
		
		//Name of reference method and target can be different also return type but method signature should be same
		MethodReferenceInterface MethodReferenceInterface3 = new MethodReferenceDemo1()::helloMethodReference1;
		MethodReferenceInterface3.helloMethodReference();
		
	}

}
