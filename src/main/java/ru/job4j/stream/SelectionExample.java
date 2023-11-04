package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class SelectionExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        List<String> rsl = strings
                .stream()
                .skip(2)
                .limit(2)
                .toList();
        System.out.println(rsl);

        String rsl1 = strings
                .stream()
                .skip(2)
                .limit(2)
                .findFirst()
                .orElse("По умолчанию");
        System.out.println(rsl1);

        String rsl2 = strings
                .stream()
                .skip(strings.size() - 1)
                .limit(2)
                .findFirst()
                .orElse("По умолчанию");
        System.out.println(rsl2);
    }
}
