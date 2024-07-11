package org.example.optional;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args){
        String x = null;

        Optional<String> y = Optional.ofNullable(x);
        System.out.println(y);
        if(y.isPresent()){
            System.out.println(y.get());
        }
        else{
            System.out.println("No value");
        }

        x = "hello";
        Optional<String> z = Optional.ofNullable(x);
        System.out.println(z);
    }
}
