package ru.job4j.oop;

public class HierarchyUsage {
    public static void main(String[] args) {
        Car car = new Car("Lada", "Granta");
        Transport tp = car;
        Object obj = car;
        Object ocar = new Car("Lada", "Vesta");
        Car carFromObject = (Car) ocar;
    }
}
