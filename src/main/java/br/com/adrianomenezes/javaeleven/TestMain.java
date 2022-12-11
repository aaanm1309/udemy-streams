package br.com.adrianomenezes.javaeleven;


import br.com.adrianomenezes.javaeight.CustomArrayList;
import br.com.adrianomenezes.javaeight.CustomList;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestMain {
    public static void main(String[] args) throws IOException {
        int num = 10;
        var num2 = 10;

        List<Integer> l = List.of(1,2,3,4,5,6);
        var l2 = List.of(1,2,3,4,5,6);

        Map<String, Integer> mapCreated = Map.of(
                "name1",12,
                "name3",33,
                "name5",44
        );
        var mapNewCreated = Map.of(
                "name1",12,
                "name3",33,
                "name5",44
        );

        var newList =
                l2.stream()
                        .filter( i -> i%2 ==0)
                        .collect(Collectors.toList());

        newList.add(43);

        var newListImm =
                l2.stream()
                        .filter( i -> i%2 ==0)
                        .collect(Collectors.toUnmodifiableList());

//        newListImm.add(43);
        newList.forEach(System.out::println);
        System.out.println("------");
        newListImm.forEach(System.out::println);
        System.out.println("------");
        l.forEach(i -> System.out.println(i*i));
        System.out.println("------");

        var s = "";
        System.out.println(s.isEmpty());
        System.out.println(s.isBlank());
        System.out.println("------");
        var s2 = " ";
        System.out.println(s2.isEmpty());
        System.out.println(s2.isBlank());
        System.out.println("------");
        var s3 = "   \n  ";
        System.out.println(s3.isEmpty());
        System.out.println(s3.isBlank());
        System.out.println("------");
        var s4 = "   c  ";
        System.out.println(s4.isEmpty());
        System.out.println(s4.isBlank());
        System.out.println("------");
//        String s5 = null;
//        System.out.println(s5.isEmpty());
//        System.out.println(s5.isBlank());
//        System.out.println("------");

        var str = "hi\nhello\nhow are you\n";
        var list = str.lines()
                .collect(Collectors.toList());
        list.forEach(System.out::println);
        System.out.println("------");

        System.out.println(str.repeat(3));
        System.out.println("------");

        var str123 = " far vbs ";
        char c = '\u2002';
        System.out.println("::"+str123+"::");
        System.out.println("::"+str123.trim()+"::");
        str123 = c + str123;
        System.out.println("::"+str123.trim()+"::");
        System.out.println("::"+str123.strip()+"::");
        System.out.println("::"+str123.stripLeading()+"::");
        System.out.println("::"+str123.stripIndent()+"::");

        Path path = Paths.get("./readme.md");
        Files.writeString(path, "Adriano is very cool");
        Files.writeString(path, "Adriano is very cool2");

        System.out.println(
                Files.readAllLines(path)
                        .stream()
                        .collect(Collectors.toList())
        );

        System.out.println("------");
        var newList3 =
                l2.stream()
                        .filter( i -> i > 01)
                        .findFirst();
        if (newList3.isPresent()){
            System.out.println(newList3.get());
        }
        var newList2 =
                l2.stream()
                        .filter( i -> i > 10)
                        .findFirst();
        if (newList2.isPresent()){
            System.out.println(newList2.get());
        }
        System.out.println("------");
    }
}
