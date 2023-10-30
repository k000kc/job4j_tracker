package ru.job4j.lambda;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MapLambdaUsage {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "name");
        map.put(2, "top");
        map.put(3, "user");
        map.put(4, "precision");
        map.put(5, "post");

        map.forEach((key, value) -> System.out.println("Key: " + key + ", value: " + value));
        System.out.println();
        BiFunction<Integer, String, String> function = (key, value) -> value + "_" + key;
        map.replaceAll(function);
        map.forEach((key, value) -> System.out.println("Key: " + key + ", value: " + value));
        System.out.println();

        Map<Integer, String> map1 = new HashMap<>();
        map1.put(1, "name");
        BiFunction<Integer, String, String> function1 = (key, value) -> value + "_" + key;
        String result = map1.computeIfPresent(1, function1);
        System.out.println("Current value: " + result);
        map1.forEach((key, value) -> System.out.println("Key: " + key + ", value: " + value));
        System.out.println();

        Map<String, Integer> map2 = new HashMap<>();
//        map2.put("Petr", 5);
        Function<String, Integer> function2 = String::length;
        System.out.println("Result: " + map2.computeIfAbsent("Petr", function2));
        System.out.println("Result: " + map2.computeIfAbsent("Petr", key -> key.length() + 10));
        map2.forEach((key, value) -> System.out.println("Key: " + key + ", value: " + value));
        System.out.println();

        Map<String, Integer> map3 = new HashMap<>();
        map3.put("Shoes", 200);
        BiFunction<Integer, Integer, Integer> function3 = (oldValue, newValue) -> oldValue - newValue;
        int newPrice = map3.merge("Shoes", 50, function3);
        System.out.println("New price: " + newPrice);
        System.out.println("Price of shirt: " + map3.merge("Shirt", 100, function3));

        map3.forEach((key, value) -> System.out.println("Key: " + key + ", value: " + value));
    }
}
