package main.java.com.application.java8.joda;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class JodaAssignment1 {

	public static void main(String[] args) {

		Consumer<LocalDate> isPasswordExpired = localDate -> {
			long passwordExpiryDays = 30;
			LocalDate currentDate = LocalDate.now();
			Period diff = Period.between(currentDate, localDate);
			Predicate<Period> predicate =  difference -> diff.getYears() < 0 || diff.getMonths() < 0
					|| (diff.getYears() == 0 && diff.getMonths() == 0 && diff.getDays() > passwordExpiryDays);
		
			if (predicate.test(diff)) {
				System.out.println("Your password has expired");
			}
		};

		LocalDate passwordSetOnDate = LocalDate.of(2019, 1, 1);
		isPasswordExpired.accept(passwordSetOnDate);
		
		isPasswordExpired1();
		isPasswordExpired2();

	}

	private static void isPasswordExpired2() {
		LocalDate passwordSetonDate = LocalDate.of(2020,1,1);
		long passwordExpoiryDays = 30;
		LocalDate currentDate = LocalDate.now();
		int difference =currentDate.getDayOfYear() - passwordSetonDate.getDayOfYear();
		if(difference > passwordExpoiryDays) {
		    System.out.println("Your Password has expired");
		}
	}

	private static void isPasswordExpired1() {

		LocalDate passwordSetOnDate = LocalDate.of(2019, 1, 1);
		long passwordExpiryDays = 30;
		LocalDate currentDate = LocalDate.now();

		if (passwordSetOnDate.until(currentDate, ChronoUnit.DAYS) > passwordExpiryDays)
			System.out.println("Your Password has expired");

	}

}
