package br.com.adrianomenezes.assignments;


import javax.xml.namespace.QName;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class TestMainAssignment1 {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("./src/main/java/br/com/adrianomenezes/assignments/first-name.txt");
//        Files.readAllLines(path)
//                .forEach(System.out::println);
        List<String> strings = Files.readAllLines(path);
        startsWithB(strings);
        System.out.println("-----");

        startsWithCAndContainsC(strings);
        System.out.println("-----");

        countStartWithM(strings);
        System.out.println("-----");

        countStartWithM(strings);
        System.out.println("-----");

        locateMinusAndChangeToSpace(strings);
        System.out.println("-----");

        locateHugeNames(strings);
        System.out.println("-----");

    }

    private static void locateHugeNames(List<String> strings) {
        var listResult =
                strings.stream()
                        .max( Comparator.comparing( s -> s.length()))
                        .get()
                ;

        System.out.println(listResult);


    }


    private static void locateMinusAndChangeToSpace(List<String> strings) {
        var listResult =
                strings.stream()
                        .filter(s -> s.contains("-"))
                        .map(name -> name.strip().replace("-"," "))
                        .collect(Collectors.toList())
        ;

        System.out.println(listResult);
        System.out.println(listResult.size());

    }

    private static void countStartWithM(List<String> strings) {
        System.out.println(
                strings.stream()
                    .filter(s -> s.toLowerCase().startsWith("m"))
                    .map(name -> name.strip().length())
                    .mapToInt(i -> i)
                    .sum()
        );

    }

    private static void startsWithCAndContainsC(List<String> strings) {
        List<String> collect = strings.stream()
                .filter(s -> s.toLowerCase().startsWith("c"))
                .filter(s -> s.toLowerCase().contains("s"))
                .collect(Collectors.toList());
        System.out.println(
                collect.size()
        );
    }

    private static void startsWithB(List<String> strings) {
        System.out.println(
        strings.stream()
                .filter( s -> s.toLowerCase().startsWith("b"))
                .count()
        );
    }
}
