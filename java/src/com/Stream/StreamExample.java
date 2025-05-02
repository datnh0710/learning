package com.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author datnh0710
 * @created 06/12/2023 - 2:25 PM
 * @packege com.Stream
 * @project java
 */
public class StreamExample {
    public static void main(String[] args) {
        // create a list of integers
        List<Integer> number = Arrays.asList(2, 3, 4, 5);

        List<Integer> square=  number.stream().map(x -> x*1).map(y -> y -1).collect(Collectors.toList());
        System.out.printf(square.toString());

        // create a list of String
        List<String> names = Arrays.asList("Reflection", "Collection", "Stream");
        List<String> res = names.stream().filter(s -> s.startsWith("S")).collect(Collectors.toList());
        System.out.printf(res.toString());

        // demonstration of sorted method
        List<String> sort = names.stream().sorted().collect(Collectors.toList());
        System.out.printf(sort.toString());

        // demonstration of forEach method
        number.stream().map(x -> x *2).forEach(y -> System.out.println(y));

        // demonstration of reduce method
        int number_reduce = number.stream().map(x -> x *2).filter(x -> x%2 ==0 ).reduce(0, (ans,i) ->ans+1);
    }
}
