package br.com.adrianomenezes.function;

import java.util.function.Function;

public class TestMain {


	public static void main(String[] args) {

		// consumer não altera a lista principal.... Diferente de Function... Por que retorna algo

		Function<String, Integer> strLen = s -> s.length();
		Function<Integer, Integer> square = i -> i*i;
		System.out.println(
				"the return (1) is :: "+
				strLen.andThen(square).apply("Hi hello how are you")
		);

		// example 2

		Function<Integer, Integer> plusTwo = i -> i + 2;

		System.out.println(
				"the return (2) is :: "+
						plusTwo.andThen(square).apply(8)
		);

		// andthen a.andthen(b) => a -> b
		// compose a.compose(b) => b -> a  ---- primeiro executa o do compose e depois o primeiro

		System.out.println(
				"the return (3) is :: "+
						plusTwo.compose(square).apply(8)
		);

	}

}
