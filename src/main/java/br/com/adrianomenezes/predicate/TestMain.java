package br.com.adrianomenezes.predicate;

import java.util.function.Predicate;

public class TestMain {


	public static void main(String[] args) {

		Predicate<Double> isGT2 = n -> n > 2;
		Predicate<Double> isLT10 = n -> n < 10;

		System.out.println("------------");
		System.out.println(isGT2.test(5d));
		System.out.println(isLT10.test(5d));

		System.out.println("------------");
		System.out.println(isGT2.test(15d));
		System.out.println(isLT10.test(15d));

		System.out.println("------------");
		System.out.println(isGT2.and(isLT10).test(15d));
		System.out.println(isGT2.and(isLT10).test(1d));
		System.out.println(isGT2.and(isLT10).test(5d));

		System.out.println("------------");
		System.out.println(isGT2.or(isLT10).test(15d));
		System.out.println(isGT2.or(isLT10).test(1d));
		System.out.println(isGT2.or(isLT10).test(5d));
		System.out.println("------------");

		System.out.println(isGT2.or(isLT10).negate().test(15d));
		System.out.println(isGT2.or(isLT10).negate().test(1d));
		System.out.println(isGT2.or(isLT10).negate().test(5d));
		System.out.println("------------");

	}

}
