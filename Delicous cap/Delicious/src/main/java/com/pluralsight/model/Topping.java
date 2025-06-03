package com.pluralsight.model;

public abstract class Topping implements Priceable {
    private String name;

    public Topping(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    @Override
    public abstract double getPrice();

    @Override
    public String toString() {
        return name;
    }
}
