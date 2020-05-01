package main.java.com.application.java8.joda;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class JodaDemo1 {

	public static void main(String... args) {
			
		getCurrentLocalDateTime();
		getCurrentDateDetails();
		getCurrentTimeDetails();
		setDate();
		manipulateDate();
		
	}

	private static void manipulateDate() {
		
		LocalDate localDate = LocalDate.of(2020, Month.JANUARY, 1);
		System.out.println("Date after two days " + localDate.plusDays(2));
		System.out.println("Date before two days " + localDate.minusDays(2));
		if( localDate.isBefore(LocalDate.now()) ) {
			System.out.println(localDate + " Date is before current date " );
		}
		if( LocalDate.now().isAfter(localDate) ){
			System.out.println("Current date is after " + localDate);
		}
		if( LocalDate.now().isEqual(localDate) ) {
			System.out.println("Current date and " + localDate + " are equal ");
		}
		else {
			System.out.println("Current date and " + localDate + " are not equal ");
		}
	}

	private static void setDate() {
		
		LocalDate localDate = LocalDate.of(2020, Month.JANUARY, 1);
		System.out.println("New year " + localDate);
		
	}

	private static void getCurrentTimeDetails() {
		
		LocalTime localTime = LocalTime.now();
		System.out.println("Get hours from time " + localTime.getHour());
		System.out.println("Get minutes from time " + localTime.getMinute());
		System.out.println("Get seconds from time " + localTime.getSecond());
	}

	private static void getCurrentDateDetails() {
		
		LocalDate localDate = LocalDate.now();
		System.out.println("Get year from date " + localDate.getYear());
		System.out.println("Get month from date " + localDate.getMonth());
		System.out.println("Get day of week from date " + localDate.getDayOfWeek());
		System.out.println("Get day of month from date " + localDate.getDayOfMonth());
		System.out.println("Get day of year " + localDate.getDayOfYear());
		
	}

	private static void getCurrentLocalDateTime() {
		
		LocalDate localDate = LocalDate.now();
		LocalTime localTime = LocalTime.now();
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println("LocalDate : " + localDate);
		System.out.println("LocalTime : " + localTime);
		System.out.println("LocalDateTime : " + localDateTime);
		
	}

}
