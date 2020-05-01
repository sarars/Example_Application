package main.java.com.application.java8.parallelStream;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ParallelStreamDemo {

	public static void main(String[] args) {
		
		Instant startStream = Instant.now();
		withStream();
		Instant endStream = Instant.now();
		Duration durationForStream = Duration.between(startStream, endStream);
		System.out.println("With stream : " + durationForStream.toMillis());
		
		Instant startParallel = Instant.now();
		withParallelStream();
		Instant endParallel = Instant.now();
		Duration durationForParallel = Duration.between(startParallel, endParallel);
		System.out.println("With parallel stream : " + durationForParallel.toMillis());
		
		
	}

	private static void withStream() {
		
		List<Integer> intList = new ArrayList<>();
		for ( int i=0 ; i < 70000 ; i++)
		{
			intList.add(i);
		}
		
		Predicate<Integer> evenPredicate = even -> even % 2 == 0;
		
		intList.stream().filter(evenPredicate).collect(Collectors.toList());
	}

	private static void withParallelStream() {
		
		List<Integer> intList = new ArrayList<>();
		for ( int i=0 ; i < 70000 ; i++)
		{
			intList.add(i);
		}
		
		Predicate<Integer> evenPredicate = even -> even % 2 == 0;
		
		intList.parallelStream().filter(evenPredicate).collect(Collectors.toList());
		
	}

}
