package main.java.com.application.java7;

public class MultiCatchDemo {

	private void m1() {
		System.out.println("In method m1");
	}
	
	private void m2() {
		System.out.println("In method m2");
	}
	
	private void m3() {
		System.out.println("In method m3");
	}
	
	public static void main(String[] args) {
		
		MultiCatchDemo m = new MultiCatchDemo();
		int myArray[] = new int[5];
		String nullString = null;

		try {

			int result = 100 / 0;
			System.out.println(myArray[10]);
			nullString.equals("JFF");

		} catch (ArithmeticException | ArrayIndexOutOfBoundsException | NullPointerException e) {

			System.out.println("Exception in the main method");

			if (e instanceof ArithmeticException)
			{
				m.m1();
			}

			if (e instanceof NullPointerException)
			{
				m.m2();
			}

			if (e instanceof ArrayIndexOutOfBoundsException)
			{
				m.m3();
			}

		}
		
	}

}
