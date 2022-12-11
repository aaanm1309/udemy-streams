package br.com.adrianomenezes.runnable;

import com.google.common.util.concurrent.Uninterruptibles;

import java.util.concurrent.TimeUnit;

public class TestMain {


	public static void main(String[] args) {

		Runnable r = () -> {
			Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
			System.out.println("Ola bebe");
		};
		new Thread(r).start();

		System.out.println("Hi");



	}

}
