package br.com.adrianomenezes;

import br.com.adrianomenezes.lambda.*;
import br.com.adrianomenezes.polimorphism.Dog;

import java.util.ArrayList;
import java.util.List;

public class TestMain {
	private static final List<String> list = new ArrayList<>();

	public static void main(String[] args) {
		int a = 5;
		Dog d = new Dog();
//		List list = new ArrayList<>();

		GreetingService hiService = (String name) ->
				System.out.println("Hi ... " + name);
		GreetingService helloService = (name) ->
				System.out.println("Hello ... " + name);
		PeopleService peopleService = (fn, ln, age) -> {
			System.out.println("my name is " + fn + " " + ln);
			System.out.println("my age is  " + age);
		};
		hiService.greet("Eu mesmo");
		helloService.greet("Eu denovo");

		peopleService.whoIsThePerson("Bele", "Baba", 28);


		GreetingReturnService hiReturnService = (n) -> {
			return n.toUpperCase();
		};

		System.out.println(hiReturnService.greet("cesinha"));

		StringOperations1 op2 = String::concat;
		System.out.println(op2.accept("Adriano","Menezes"));



		StringOperations op1 = list::add;

		op1.accept("adriano");
		op1.accept("giovanna");
		System.out.println(list);


	}

}
