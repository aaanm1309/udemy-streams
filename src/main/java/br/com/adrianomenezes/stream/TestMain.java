package br.com.adrianomenezes.stream;


import java.util.ArrayList;
import java.util.List;

public class TestMain {

	public static void main(String[] args) {

		List<Integer> listInt =  new ArrayList<>();

		listInt.add(9);
		listInt.add(10);
		listInt.add(11);
		listInt.add(12);
		listInt.add(1);
		listInt.add(2);
		listInt.add(6);
		listInt.add(7);
		listInt.add(3);
		listInt.add(4);
		listInt.add(5);
		listInt.add(8);


		System.out.println("""
				Starting""");
		listInt.stream()
				.filter(i -> {
					System.out.println("filter-received :: " + i);
					return i%2 == 0;
				})
				.sorted()
				.limit(3)
				.map(i -> {
					System.out.println("map-received :: " + i);
					return i * i;
				})
				.forEach(System.out::println);
		System.out.println("-------");

		listInt.stream()
				.skip(8)
				.peek(i -> System.out.println("filter-received :: " + i))
				.filter(i ->  i%2 == 0)
				.peek(i -> System.out.println("filter-exit :: " + i))
				.limit(3)
				.sorted()
				.peek(i -> System.out.println("map-received :: " + i))
				.map(i ->  i * i)
				.peek(i -> System.out.println("map-exit :: " + i))
				.forEach(System.out::println);

		System.out.println("-------");

		listInt.stream()
				.peek(i -> System.out.println("filter-received :: " + i))
				.filter(i ->  i%2 == 0 && i > 5)
//				.sorted()
				.peek(i -> System.out.println("map-received :: " + i))
				.map(i ->  (i * i) + 2 )
				.peek(i -> System.out.println("map-exit :: " + i))
				.forEach(System.out::println);


		System.out.println("""
				Ending""");

//		List<Integer> listresult =
//				listInt.stream()
//						.filter(i -> i%2 == 0)
//						.limit(3)
//						.map(i -> i * i)
//						.collect(Collectors.toList());

	}

}
