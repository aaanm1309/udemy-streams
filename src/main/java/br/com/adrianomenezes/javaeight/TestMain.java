package br.com.adrianomenezes.javaeight;


import java.util.ArrayList;
import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        List l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
//        l.forEach();

        CustomList list = new CustomArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
//        list.forEach()   - antes de incluir o default

        list.forEach(i -> System.out.println(i*i));
    }
}
