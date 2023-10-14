package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Ivan@mail.ru", "Ivanov Ivan");
        map.put("Petr@mail.ru", "Petr Petrov");
        map.put("test@mail.ru", "Test Testov");
        for (String email : map.keySet()) {
            System.out.printf("%s - %s%n", email, map.get(email));
        }
    }
}
