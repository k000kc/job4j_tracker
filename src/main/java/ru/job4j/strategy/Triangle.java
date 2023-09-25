package ru.job4j.strategy;

public class Triangle implements Shape {
    @Override
    public String drow() {
        String ln = System.lineSeparator();
        return    "   ^    " + ln
                + " /   \\ " + ln
                + "/_____\\" + ln;
    }
}
