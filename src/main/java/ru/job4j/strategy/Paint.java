package ru.job4j.strategy;

public class Paint {
    public void drow(Shape shape) {
        System.out.println(shape.drow());
    }

    public static void main(String[] args) {
        Paint context = new Paint();
        context.drow(new Triangle());
        context.drow(new Square());
    }
}
