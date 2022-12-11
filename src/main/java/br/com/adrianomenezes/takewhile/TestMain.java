package br.com.adrianomenezes.takewhile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestMain {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
				Collections.addAll( numbers,4,2,1,4,5,3, 2,1, 6,1,4,3,5,2,1);


		System.out.println(
				numbers.stream()
						.filter(i -> i < 5)
						.collect(Collectors.toList())
		);

		System.out.println(
				numbers.stream()
						.takeWhile(i -> i < 5)
						.collect(Collectors.toList())
		);

		System.out.println(
				numbers.stream()
						.dropWhile(i -> i < 5)
						.collect(Collectors.toList())
		);

		System.out.println(
				numbers.stream()
						.sorted((a,b)-> {
							if (a <= b) {
								return a;
							} else {
								return b;
							}
						})
						.filter(i -> i < 5)
						.collect(Collectors.groupingBy(i-> i))
		);

		System.out.println(
				numbers.stream()
						.sorted((a,b)-> {
							if (a <= b) {
								return a;
							} else {
								return b;
							}
						})
						.takeWhile(i -> i < 5)
						.collect(Collectors.groupingBy(i-> i))
		);

		System.out.println(
				numbers.stream()
						.sorted((a,b)-> {
							if (a <= b) {
								return a;
							} else {
								return b;
							}
						})
						.dropWhile(i -> i < 5)
						.collect(Collectors.groupingBy(i-> i))
		);

	}

}
