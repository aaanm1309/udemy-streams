package br.com.adrianomenezes.collect;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TestMain {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();

		list.add("Apple");
		list.add("Apple");
		list.add("Airplane");
		list.add("Ball");
		list.add("Boy");
		list.add("Cat");
		list.add("Dog");
		list.add("Delta");

		List<String> newList = list.stream()
				.filter(s -> s.length() > 3)
				.collect(Collectors.toList());

		Set<String> newSet = list.stream()
				.filter(s -> s.length() > 3)
				.collect(Collectors.toSet());

		System.out.println("Original List :: " + list);
		System.out.println("New List :: " + newList);
		System.out.println("New set :: " + newSet);

		String joiningList = list.stream()
				.filter(s -> s.length() > 3)
				.collect(Collectors.joining());
		System.out.println("Joining :: " + joiningList);

		String joiningList2 = list.stream()
				.filter(s -> s.length() > 3)
				.collect(Collectors.joining(";"));
		System.out.println("Joining :: " + joiningList2);

		Map<Integer,List<String>> groupingBy = list.stream()
				.collect(Collectors.groupingBy(s -> s.length()));
		System.out.println("Grouping by lenght :: " + groupingBy);

		Map<Character,List<String>> groupingBy2 = list.stream()
				.collect(Collectors.groupingBy(s -> s.charAt(0)));
		System.out.println("Grouping by first char :: " + groupingBy2);

	}

}
