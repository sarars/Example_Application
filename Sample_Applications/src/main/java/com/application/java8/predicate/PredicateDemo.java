package main.java.com.application.java8.predicate;

import java.util.function.Predicate;

public class PredicateDemo {
	
	public static void main(String... args) {
		
		Integer transactionAmount = 100;
		withoutPredicate(transactionAmount);
		withPredicate(transactionAmount);
	}

	private static void withPredicate(Integer transactionAmount) {
		Predicate<Integer> p = transaction -> transaction > 1000;
		if(p.test(transactionAmount)) {
			System.out.println("Transaction amount : " + transactionAmount + " is greater than 1000");
		}
		else {
			System.out.println("Transaction amount : " + transactionAmount + " is lesser than 1000");
		}
	}

	private static void withoutPredicate(Integer transactionAmount) {
		
		if(isGreaterThan(transactionAmount)) {
			System.out.println("Transaction amount : " + transactionAmount + " is greater than 1000");
		}
		else {
			System.out.println("Transaction amount : " + transactionAmount + " is lesser than 1000");
		}
	}

	private static boolean isGreaterThan(Integer transactionAmount) {
		
		if(transactionAmount > 1000) {
			return true;
		}
		else {
			return false;
		}
	}

}
