package br.com.adrianomenezes.countAndOthers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestMain {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("apple");
		list.add("ball");
		list.add("cat");
		list.add("monkey");
		list.add("dog");
		list.add("banana");

		var result = list.stream()
				.count();
		System.out.println("Count result is :: " + result);

		result = list.stream()
				.filter(l -> l.length() > 3)
				.count();
		System.out.println("Count result is :: " + result);


		var result2 = list.stream()
				.filter(l -> l.length() > 5)
				.findFirst();

		System.out.println("FindFirst result is :: " + result2);
		if (result2.isPresent()){
			System.out.println("Exist something in the list");

		}

		result2 = list.stream()
				.filter(l -> l.length() > 7)
				.findFirst();

		System.out.println("FindFirst result is :: " + result2);
		if (result2.isPresent()){
			System.out.println("Exist something in the list");
		}

		var result3 = list.stream()
				.min(Comparator.naturalOrder());
		if (result3.isPresent()){
			System.out.println("Min Natural Order result is :: " + result3.get());
		}

		result3 = list.stream()
				.min(Comparator.reverseOrder());
		if (result3.isPresent()){
			System.out.println("Min reverse Order result is :: " + result3.get());
		}

		result3 = list.stream()
				.max(Comparator.naturalOrder());
		if (result3.isPresent()){
			System.out.println("Max Natural Order result is :: " + result3.get());
		}

		result3 = list.stream()
				.max(Comparator.reverseOrder());
		if (result3.isPresent()){
			System.out.println("Max reverse Order result is :: " + result3.get());
		}

		var result4 = list.stream()
				.anyMatch(s -> s.contains("ana"));

		System.out.println("AnyMatch result for 'ana' is :: " + result4);

		result4 = list.stream()
				.noneMatch(s -> s.contains("ana"));

		System.out.println("NoneMatch result for 'ana' is :: " + result4);

	}

}
