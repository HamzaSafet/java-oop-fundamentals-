package net.safty;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class AppFunction {
    public static void main(String[] args) {
        //hta hado des interface fonctionnelle
        //interface foncionnelle des base
        Consumer<String> consumer=(input)->{
            System.out.println(input);
        };
        consumer.accept("hello");

        Supplier<String> supplier=()->{
           return  "azerty";
        };
        System.out.println(supplier.get());

        Function<Integer,Integer> function=(a)->{
            return a*2;
        };
        System.out.println(function.apply(50));
    }


}
