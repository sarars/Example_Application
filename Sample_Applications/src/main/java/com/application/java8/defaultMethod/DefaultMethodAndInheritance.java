package main.java.com.application.java8.defaultMethod;

interface DefaultInterface1{
	default public void show() {
		System.out.println("In Default Interface 1");
	}
}

interface DefaultInterface2{
	default public void show() {
		System.out.println("In Default Interface 2");
	}
}

class DefaultInheritance implements DefaultInterface1,DefaultInterface2{
	@Override
	public void show() {
		DefaultInterface1.super.show();
		DefaultInterface2.super.show();
	}
}

public class DefaultMethodAndInheritance  {
	
	public static void main(String... args) {
		DefaultInheritance defaultInheritance = new DefaultInheritance();
		defaultInheritance.show();
	}

	

}
