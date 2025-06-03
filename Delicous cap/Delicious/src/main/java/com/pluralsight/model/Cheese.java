package com.pluralsight.model;

public class Cheese extends PremiumTopping{
    private String sandwichSize;
    boolean isExtra;

    public Cheese(String name, String sandwichSize, boolean isExtra) {
        super(name);
        this.sandwichSize = sandwichSize;
        this.isExtra = isExtra;
    }

    @Override
    public double getPrice() {
        double price = 0.0;
        if (sandwichSize.equals("4")) {
            price = 0.75;
        } else if (sandwichSize.equals("8")) {
            price = 1.50;
        } else if (sandwichSize.equals("12")) {
            price = 2.25;
        }

        if (isExtra) {
            if (sandwichSize.equals("4")) {
                price += 0.30;
            } else if (sandwichSize.equals("8")) {
                price += 0.60;
            } else if (sandwichSize.equals("12")) {
                price += 0.90;
            }
        }
        return price;
    }
}
