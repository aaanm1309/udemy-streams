package br.com.adrianomenezes.consumer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class TestMainBiConsumer {


	public static void main(String[] args) {

		List<String> listBi = new ArrayList<>();

		listBi.add("eu mesmo");
		listBi.add("outra pessoa");
		listBi.add("mais uma outra pessoa");

		Consumer<String> consumer = System.out::println;
		Consumer<String> consumerUpperCase = s -> System.out.println(s.toUpperCase());

		Consumer<String> dbConsumer = s -> {
			System.out.println("I am writing into DB :: " + s);
		};
		Consumer<String> loggingConsumer = s -> {
			System.out.println("I am writing into log file :: " + s);
		};

		Consumer<String> dbLogConsumer = dbConsumer.andThen(loggingConsumer);

		BiConsumer<String, Integer> biConsumer = (s,i) -> {
			System.out.println("My name :: " + s);
			System.out.println("My age :: " + i);
		};

		biConsumer.accept("Adriano",48);

		Map<String, Consumer<String>> map = new HashMap<>();
		map.put("db",dbConsumer);
		map.put("dblog",dbLogConsumer);
		map.put("log",loggingConsumer);

		map.forEach((k,v) -> {
			System.out.println("My key :: " + k);
//			System.out.println("My value :: " + v);
			listBi.forEach(v);
		});

//		listBi.forEach(consumer);
//		System.out.println("------------");
//		listBi.forEach(consumerUpperCase);
//		System.out.println("------------");
//
//		list.forEach(dbConsumer);
//		System.out.println("------------");
//		list.forEach(loggingConsumer);
//		System.out.println("------------");
//
//		list.forEach(dbLogConsumer);
//
//		System.out.println("------------");

//
//		System.setProperty("consumer-type","log");
//
//		list.forEach(map.get(System.getProperty("consumer-type")));
	}

}
