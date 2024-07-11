package org.example.streamAPI;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMap {
    public static void main(String[] args){
        Stream<String> stream = Stream.of("hello", "World", "eXample");

        Collection<String> collection = Arrays.asList("Example2", "saMple");
        Stream<String> stream2 = collection.stream();

        List<String> upper1 = stream.map(String::toUpperCase).collect(Collectors.toList());
        List<String> upper2 = stream2.map(String::toUpperCase).collect(Collectors.toList());

        System.out.println(upper1);
        System.out.println(upper2);
    }
}
