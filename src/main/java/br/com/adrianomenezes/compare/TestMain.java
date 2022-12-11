package br.com.adrianomenezes.compare;


import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class TestMain {

	public static void main(String[] args) {
		Student a = new Student("Adriano",80,150);
		Student b = new Student("Bob",96,145);
		Student c = new Student("Carl",70,180);
		Student d = new Student("Marcus",50,190);

		Optional<Student> resultStudent =
				Stream.of(a,b,c,d)
				.min(Comparator.comparing(s -> s.getScore()));
		System.out.println("Comparator Min Score :: " + resultStudent.get());

		resultStudent =
				Stream.of(a,b,c,d)
						.max(Comparator.comparing(s -> s.getScore()));
		System.out.println("Comparator Max Score :: " + resultStudent.get());

		resultStudent =
				Stream.of(a,b,c,d)
						.max(Comparator.comparing(s -> s.getHeight()));
		System.out.println("Comparator Min height :: " + resultStudent.get());

		resultStudent =
				Stream.of(a,b,c,d)
						.max(Comparator.comparing(s -> s.getHeight()));
		System.out.println("Comparator Max height :: " + resultStudent.get());

	}

}
