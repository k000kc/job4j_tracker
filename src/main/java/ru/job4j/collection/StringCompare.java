package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int rsl = -1;
        for (int i = 0; i < o1.length() && i < o2.length(); i++) {
            rsl = Character.compare(o1.charAt(i), o2.charAt(i));
            if (rsl != 0) {
                break;
            }
        }
        return rsl == 0 ? Integer.compare(o1.length(), o2.length()) : rsl;
    }
}
