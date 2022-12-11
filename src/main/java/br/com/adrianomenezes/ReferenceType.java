package br.com.adrianomenezes;

import java.util.Arrays;

public class ReferenceType {
	public static void main( String[] args )
	{


		int[] arr = {1,2,3};
		System.out.println("Before: "+ Arrays.toString(arr));
		change(arr);
		System.out.println("After: "+Arrays.toString(arr));

		Integer i = 5;
		System.out.println("Before: "+i);
		change(i);
		System.out.println("After: "+i);
	}

	private static void change(int[] a) {
		a[0]++;
		a[1]++;
		a[2]++;
	}
	private static void change(Integer b) {
		b++;
	}
}
