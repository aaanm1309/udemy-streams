package br.com.adrianomenezes.polimorphism;

public class Dog extends Animal{
	public void makeSound(){
		System.out.println("I am a dog. barking.");
	}
	public void eat(){
		System.out.println("I am eating meat");
	}
}
