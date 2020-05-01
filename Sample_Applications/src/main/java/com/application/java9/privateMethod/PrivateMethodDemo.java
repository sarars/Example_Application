package main.java.com.application.java9.privateMethod;

import java.util.Random;

interface PrivateMethodInterface{
	
	private static int generateRandomNumber() {
		Random random = new Random();
		return random.nextInt(5000);
	}
	
	 static int displayRandomNumber1() {
		return generateRandomNumber();
	}
	
	 static String displayRandomNumber2() {
		
		String appendCode = "R_" + generateRandomNumber();
		return appendCode;
	}
	 
}


public class PrivateMethodDemo implements PrivateMethodInterface {
	

	public static void main(String... args) {
		
		System.out.println("Random example 1 : " + PrivateMethodInterface.displayRandomNumber1());
		System.out.println("Random example 2 : " + PrivateMethodInterface.displayRandomNumber2());
	}


}
