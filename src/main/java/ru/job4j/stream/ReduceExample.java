package ru.job4j.stream;

import ru.job4j.stream.mapto.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceExample {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4);
        Optional<Integer> sum = nums.stream()
                .reduce((a, b) -> a + b);
        System.out.println(sum.get());

        List<String> str = List.of("Один", "Два", "Три");
        Optional<String> sum1 = str.stream()
                .reduce((a, b) -> a + ", " + b);
        System.out.println(sum1.get());

        int sum3 = nums.stream()
                .reduce(2, (a, b) -> a + b);
        System.out.println(sum3);

        List<Person> people = Arrays.asList(
                new Person("Михаил", 35),
                new Person("Ольга", 26),
                new Person("Антон", 20),
                new Person("Виктор", 16),
                new Person("Анна", 29)
        );
        int summ = people.stream()
                .reduce(
                        0,
                        (a, b) -> {
                            if (b.getAge() > 25) {
                                return a + b.getAge();
                            } else {
                                return a;
                            }
                        },
                        (a, b) -> a + b
                );
        System.out.println(summ);

        int min = people.parallelStream()
                .reduce(
                        0,
                        (a, b) -> a + b.getAge(),
                        Integer::min
                );
        System.out.println(min);
    }
}
