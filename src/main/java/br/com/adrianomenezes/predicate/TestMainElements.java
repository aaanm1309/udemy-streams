package br.com.adrianomenezes.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class TestMainElements {


	public static void main(String[] args) {

		List<String> listElements =  new ArrayList<>();
		listElements.add("          ");
		listElements.add("teste 123443243");
		listElements.add("Adriano");
		listElements.add(" Giovanna ");
		listElements.add("");
		listElements.add("Marcela");
		listElements.add(" Marta ");
		listElements.add("sarita");
		listElements.add(" jonas ");

		System.out.println("Quantidade Anterior :: "  + listElements.size());
		Consumer<String> printConsumer = System.out::println;
		Predicate<String> isBlank = s -> s.trim().isBlank();
		Predicate<String> hasLetterS = s ->  s.toLowerCase().contains("s");

//		listElements.removeIf(isBlank);
//		listElements.forEach(printConsumer);
//		System.out.println("Quantidade Sem Brancos/Vazios :: "  + listElements.size());
//
//		listElements.removeIf(hasLetterS);

		listElements.removeIf(isBlank.or(hasLetterS));
		listElements.forEach(printConsumer);
		System.out.println("Quantidade Final :: "  + listElements.size());
//
//		System.out.println("------------");
//		System.out.println(isGT2.test(5d));
//		System.out.println(isLT10.test(5d));
//
//		System.out.println("------------");
//		System.out.println(isGT2.test(15d));
//		System.out.println(isLT10.test(15d));
//
//		System.out.println("------------");
//		System.out.println(isGT2.and(isLT10).test(15d));
//		System.out.println(isGT2.and(isLT10).test(1d));
//		System.out.println(isGT2.and(isLT10).test(5d));
//
//		System.out.println("------------");
//		System.out.println(isGT2.or(isLT10).test(15d));
//		System.out.println(isGT2.or(isLT10).test(1d));
//		System.out.println(isGT2.or(isLT10).test(5d));
//		System.out.println("------------");
//
//		System.out.println(isGT2.or(isLT10).negate().test(15d));
//		System.out.println(isGT2.or(isLT10).negate().test(1d));
//		System.out.println(isGT2.or(isLT10).negate().test(5d));
//		System.out.println("------------");

	}

}
