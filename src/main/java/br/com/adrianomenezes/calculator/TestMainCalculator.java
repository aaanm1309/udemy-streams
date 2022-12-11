package br.com.adrianomenezes.calculator;

public class TestMainCalculator {


	public static void main(String[] args) {


		Calculator.addOperation("^",(a,b) -> (int) Math.pow(a,b));
		Calculator.addOperation("%",(a,b) -> a % b);

		String testCalculator = "5 + 2 - 3 * 7 + 2 / 3";
		System.out.println("5 + 2 - 3 * 7 + 2 / 3  ::: " + Calculator.calculate(testCalculator));

		testCalculator = "10 / 2 * 3 - 3 / 3 * 5";
		System.out.println("10 / 2 * 3 - 3 / 3 * 5  ::: " + Calculator.calculate(testCalculator));

		testCalculator = "9 * 9 - 1 * 7 / 8 + 30";
		System.out.println("9 * 9 - 1 * 7 / 8 + 30  ::: " + Calculator.calculate(testCalculator));

		testCalculator = "9 * 9 - 1 * 7 / 8 + 30 ^ 2";
		System.out.println("9 * 9 - 1 * 7 / 8 + 30 ^ 2  ::: " + Calculator.calculate(testCalculator));

		testCalculator = "9 * 9 - 1 * 7 / 8 + 30 ^ 2 % 3";
		System.out.println("9 * 9 - 1 * 7 / 8 + 30 ^ 2 % 3 ::: " + Calculator.calculate(testCalculator));





	}

}
