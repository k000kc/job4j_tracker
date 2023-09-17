package ru.job4j.condition;

public class Max {
    public int max(int first, int second) {
        return Math.max(first, second);
    }

    public int max(int first, int second, int third) {
        return Math.max(max(first, second), third);
    }

    public int max(int first, int second, int third, int fourth) {
        return Math.max(max(first, second, third), fourth);
    }
}
