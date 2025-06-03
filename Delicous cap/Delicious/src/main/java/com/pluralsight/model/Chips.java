package com.pluralsight.model;

public class Chips implements Priceable{
    private  String type;

    public Chips(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public double getPrice() {
//        Chips has a fixed price
        return 1.50;
    }
    @Override
    public String toString() {
        return type + " Chips - $" + String.format("%.2f", getPrice());
    }
}
