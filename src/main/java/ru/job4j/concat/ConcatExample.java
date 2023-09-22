package ru.job4j.concat;

import java.util.StringJoiner;

public class ConcatExample {
    public static void main(String[] args) {
        String str = "abc".concat("def").concat("hgi").concat("jkl");
        System.out.println(str);

        String str2 = String.join(", ", "abc", "def", "ghi");
        System.out.println(str2);

        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        stringJoiner.add("abc").add("def").add("ghi");
        System.out.println(stringJoiner);
        String joined = stringJoiner.toString();
        System.out.println(joined);
    }
}
