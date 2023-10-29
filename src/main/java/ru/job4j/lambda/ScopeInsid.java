package ru.job4j.lambda;

import java.util.function.Supplier;

public class ScopeInsid {
    public static void main(String[] args) {
        String ayyyy = "ayyyyy";
        ayyyy = ayyyy + ", People.";
        String tmp = ayyyy;
        String test = echo(
                () -> {
                    return tmp;
                }
        );
        System.out.println(ayyyy);
        System.out.println(test);
    }

    private static String echo(Supplier<String> supplier) {
        String sound = supplier.get();
        return sound + " " + sound + " " + sound;
    }
}
