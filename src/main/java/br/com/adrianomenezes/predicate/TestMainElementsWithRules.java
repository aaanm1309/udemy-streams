package br.com.adrianomenezes.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class TestMainElementsWithRules {


	public static void main(String[] args) {

		List<String> listElements =  new ArrayList<>();
		listElements.add("          ");
		listElements.add("teste 123443243");
		listElements.add("Adriano");
		listElements.add(" Giovanna ");
		listElements.add("");
		listElements.add("Marcela");
		listElements.add(" Marta ");
		listElements.add("");
		listElements.add("sarita");
		listElements.add(" jonas ");
		listElements.add("");

		System.out.println("Quantidade Anterior :: "  + listElements.size());
		Consumer<String> printConsumer = System.out::println;

		Rules.get().forEach(listElements::removeIf );

		listElements.forEach(printConsumer);
		System.out.println("Quantidade Final :: "  + listElements.size());

	}

}
