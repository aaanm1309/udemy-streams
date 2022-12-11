package br.com.adrianomenezes.immutablelist;

import java.util.*;
import java.util.stream.Collectors;

public class immutablelist {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(null);

        List<Integer> list2 = new ArrayList<>();
        Collections.addAll( list2,1,2,3,4,5,6, null);
        list2.add(9);

        List<Integer> list3 = Arrays.asList(1,2,3,4,5,6, null);
//        list3.add(9); // immutable list - constant list

        List<Integer> list4 = List.of(1,2,3,4,5,6); // null doesn't work
//        list4.add(9); // immutable list - constant list

        System.out.println(list);
        System.out.println("-------");
        System.out.println(list2);
        System.out.println("-------");
        System.out.println(list3);
        System.out.println("-------");
        System.out.println(list4);
        System.out.println("-------");

        Set<String> set1 = Set.of("ab","cc","be","xy","bx");
        System.out.println(set1);
        System.out.println(
                set1.stream()
                        .filter(s-> s.contains("b"))
                        .collect(Collectors.toSet())
        );
//        set1.add("bb");
        System.out.println("-------");

        Map<String, Integer> mapExample =  Map.of(
                "a", 10,
                "b", 15,
                "c", 21,
                "b2", 33
        );

//        mapExample.put("x",20);
        System.out.println(mapExample);
        System.out.println(
                mapExample.entrySet().stream()
                        .filter(s-> s.getKey().contains("b"))
                        .collect(Collectors.toList())
        );
//        set1.add("bb");
        System.out.println("-------");

    }
}
