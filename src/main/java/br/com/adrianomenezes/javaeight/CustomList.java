package br.com.adrianomenezes.javaeight;

import java.util.function.Consumer;

public interface CustomList {
    void add(int item);
    int size();
    int get(int index);

    default void forEach(Consumer<Integer> consumer){
        for (int i = 0; i < size(); i++) {
            consumer.accept(get(i));
        }
    }


}
