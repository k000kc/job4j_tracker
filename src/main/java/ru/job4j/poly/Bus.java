package ru.job4j.poly;

public class Bus implements Transport {
    private int passenger;
    private static final double PRICE_PER_LITER = 54;

    @Override
    public void drive() {
        System.out.println("Автобус начал ехать.");
    }

    @Override
    public void passengers(int number) {
        passenger += number;
    }

    @Override
    public double refueling(int amount) {
        return PRICE_PER_LITER * amount;
    }
}
