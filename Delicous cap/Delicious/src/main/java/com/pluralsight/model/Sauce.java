package com.pluralsight.model;

public class Sauce extends Topping{
    public Sauce(String name) {
        super(name);
    }
    @Override
    public double getPrice(){
        return 0.0;
    }
}
