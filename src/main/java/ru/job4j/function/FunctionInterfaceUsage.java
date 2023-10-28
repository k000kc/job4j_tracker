package ru.job4j.function;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.*;

public class FunctionInterfaceUsage {
    public static void main(String[] args) {
        Supplier<String> sup = () -> "New String For Interface";
        System.out.println(sup.get());

        List<String> list = List.of("one", "two", "three", "one", "two", "three");
        Supplier<Set<String>> supSet = () -> new HashSet<>(list);
        Set<String> strings = supSet.get();
        for (String s : strings) {
            System.out.println(s);
        }

        Consumer<String> consumer = (s) -> System.out.println(s + "!");
        consumer.accept(sup.get());

        BiConsumer<String, String> biConsumer = (s, s1) -> System.out.println(s + s1);
        biConsumer.accept(sup.get(), " and Second String");

        BiConsumer<Integer, String> biConsumerSet = (s, s1) -> System.out.println(s + s1);
        Set<String> strings1 = supSet.get();
        int i = 1;
        for (String s : strings1) {
            biConsumerSet.accept(i++, " is " + s);
        }

        Predicate<String> pred = s -> s.isEmpty();
        System.out.println("Строка пустая: " + pred.test(""));
        System.out.println("Строка пустая: " + pred.test("test"));

        BiPredicate<String, Integer> cond = (s, c) -> s.contains(c.toString());
        System.out.println("Строка содержит подстроку: " + cond.test("Name123", 123));
        System.out.println("Строка содержит подстроку: " + cond.test("Name", 123));

        Function<String, Character> func = s -> s.charAt(2);
        System.out.println("Третий символ в строке: " + func.apply("first"));
        System.out.println("Третий символ в строке: " + func.apply("second"));

        BiFunction<String, Integer, String> biFunc = (str, numb) -> str.concat(" ").concat(numb.toString());
        System.out.println("Результат работы бифункции: " + biFunc.apply("Name", 123));
        System.out.println("Результат работы бифункции: " + biFunc.apply("String number", 12345));

        UnaryOperator<StringBuilder> builder = b -> b.reverse();
        System.out.println("Строка после реверса: " + builder.apply(new StringBuilder("String for test")));
        System.out.println("Строка после реверса: " + builder.apply(new StringBuilder("tset rof gnirtS")));

        BinaryOperator<StringBuilder> biBuilder = (b1, b2) -> b1.append(" ").append(b2);
        System.out.println(
                "Строка после объединения: " + biBuilder.apply(
                        new StringBuilder("First string"),
                        new StringBuilder("Second string")
                )
        );
    }
}
