package br.com.adrianomenezes.sum;


import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.IntStream;

public class TestMain {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1,2,3,4,5,6,7,8,9);


        Optional<Integer> result =  list.stream()
                .reduce((a,b) ->{
                        System.out.println(a + " :: " + b);
                        return     a +b;
                        }

                );

        System.out.println(result.get());

        result =  list.stream()
                .parallel()
                .reduce((a,b) ->{
                            System.out.println(a + " :: " + b);
                            return     a +b;
                        }

                );

        System.out.println(result.get());

        int sum = list.stream()
                .mapToInt(a->a)
                .sum();
        System.out.println(sum);
        double avg = list.stream()
                .mapToInt(a->a)
                .average().getAsDouble();
        System.out.println(avg);

        //tradicional loop
        IntStream.range(0,10)
                .forEach( i -> System.out.println("Hey body :: "  + i)
                );

        IntStream.rangeClosed(0,10)
                .forEach( i -> System.out.println("Hey body :: "  + i)
                );
        System.out.println("Before :: " + LocalDateTime.now());
        LocalDateTime timeElapsed1 = LocalDateTime.now();
        long finish = 0L;
        long start = 0L;
        long timeElapsed = 0L;

        start = System.currentTimeMillis();
        int sum10 = 0 ;
        for (int i = 0; i<1000000000;i++){
            sum10 = sum10 + i;
        }
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;

        System.out.println("Time Elapsed (2) :: " + timeElapsed);


        start = System.currentTimeMillis();
        int sum1 = IntStream.range(0, 1000000000)
                .sum();
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;

        System.out.println("Time Elapsed :: " + timeElapsed);


    }
}
