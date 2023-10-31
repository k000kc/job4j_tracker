package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class FilterNegativeNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, -7, 0, 5, 2, 1, -8, 6, -2);
        List<Integer> positive = numbers.stream().filter(x -> x > 0).toList();
        positive.forEach(System.out::println);
    }
}
