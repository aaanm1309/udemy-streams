package br.com.adrianomenezes.streamof;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class TestMain {
    public static void main(String[] args) {
        String a = "Ball";
        String b = "Amplifier";
        String c = "Umbrella";
        String d = "Motorcycle";
        String e = "Helicopter";
        String f = "Adriano";

        System.out.println(
                Stream.of(a,b,c)
                        .min(Comparator.naturalOrder())
        );
        Comparator selectedOrder = Comparator.naturalOrder();
        System.out.println(
                getSmallest(a,b,c,d,e,f)
        );
        System.out.println(
                getSmallestWithOrder(selectedOrder, a,b,c,d,e,f)
        );

        selectedOrder = Comparator.reverseOrder();
        System.out.println(
                getSmallestWithOrder(selectedOrder, a,b,c,d,e,f)
        );
     }
    private static Optional<String> getSmallest( String ... vars){
        return Arrays.stream(vars).min(Comparator.naturalOrder());
    }
    private static Optional<String> getSmallestWithOrder(Comparator order, String ... vars){
        return Arrays.stream(vars).min(order);
    }
    private static  String getSmallest2(String var1,String var2,String var3){

        return var1;
    }
}
