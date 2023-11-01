package ru.job4j.stream;

import java.util.Objects;

public class Product {
    private String name;
    private float price;
    private int standart;
    private int actual;

    public Product(String name, float price, int standart, int actual) {
        this.name = name;
        this.price = price;
        this.standart = standart;
        this.actual = actual;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getStandart() {
        return standart;
    }

    public int getActual() {
        return actual;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return Float.compare(price, product.price) == 0
                && standart == product.standart
                && actual == product.actual
                && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, standart, actual);
    }
}
