package br.com.adrianomenezes.consumer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class TestMain {


	public static void main(String[] args) {

		// consumer não altera a lista principal.... Diferente de Function... Por que retorna algo

		List<String> list = new ArrayList<>();

		list.add("eu mesmo");
		list.add("outra pessoa");
		list.add("mais uma outra pessoa");

		Consumer<String> consumer = System.out::println;
		Consumer<String> consumerUpperCase = s -> System.out.println(s.toUpperCase());

		Consumer<String> dbConsumer = s -> {
			System.out.println("I am writing into DB :: " + s);
		};
		Consumer<String> loggingConsumer = s -> {
			System.out.println("I am writing into log file :: " + s);
		};

		Consumer<String> dbLogConsumer = dbConsumer.andThen(loggingConsumer);
		consumer.accept("this was returned");
		System.out.println("------------");

		list.forEach(consumer);
		System.out.println("------------");
		list.forEach(consumerUpperCase);
		System.out.println("------------");

		list.forEach(dbConsumer);
		System.out.println("------------");
		list.forEach(loggingConsumer);
		System.out.println("------------");

		list.forEach(dbLogConsumer);

		System.out.println("------------");
		Map<String, Consumer<String>> map = new HashMap<>();
		map.put("db",dbConsumer);
		map.put("log",loggingConsumer);
		map.put("dblog",dbLogConsumer);

		System.setProperty("consumer-type","log");

		list.forEach(map.get(System.getProperty("consumer-type")));
	}

}
