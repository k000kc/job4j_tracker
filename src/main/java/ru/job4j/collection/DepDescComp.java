package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] values1 = o1.split("/");
        String[] values2 = o2.split("/");
        int rsl = values2[0].compareTo(values1[0]);
        if (rsl == 0) {
            rsl = o1.compareTo(o2);
        }
        return rsl;
    }
}
