package org.example;

import java.util.function.Function;

@FunctionalInterface
interface Shape{
    void draw(int side);
}

public class Main {
    public static void main(String[] args) {
        Shape sqaure = (side) -> System.out.printf("Draw square with side: %d", side);
        sqaure.draw(10);
        System.out.println(" ");

        Function<Integer, Double> sqrt1 = (input) -> Math.sqrt(input);
        System.out.println(sqrt1.apply(4));

        Function<Integer, Double> sqrt2 = Math::sqrt;
        System.out.println(sqrt2.apply(25));
    }
}