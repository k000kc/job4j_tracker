package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int b) {
        return b - x;
    }

    public double divide(int c) {
        return (double) c / x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public double sumAllOperations(int d) {
        return sum(d) + minus(d) + divide(d) + multiply(d);
    }

    public static void main(String[] args) {
        int result = Calculator.sum(10);
        System.out.println(result);

        Calculator calculator = new Calculator();
        result = calculator.multiply(5);
        System.out.println(result);

        result = Calculator.minus(2);
        System.out.println(result);

        double result2 = calculator.divide(3);
        System.out.println(result2);

        result2 = calculator.sumAllOperations(6);
        System.out.println(result2);
    }
}
