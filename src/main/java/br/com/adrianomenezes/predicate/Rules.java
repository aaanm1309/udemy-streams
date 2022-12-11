package br.com.adrianomenezes.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Rules {
	private static final Predicate<String> isBlank = s -> s.trim().isBlank();
	private static final Predicate<String> hasLetterS = s ->  s.toLowerCase().contains("s");

	public static List<Predicate<String>>  get(){
		List<Predicate<String>> rule = new ArrayList<>();
		rule.add(isBlank);
		rule.add(hasLetterS);
		return rule;

	}
}
