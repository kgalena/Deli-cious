package com.pluralsight.model;

import java.util.ArrayList;
import java.util.List;

public class Order implements Priceable{
//    making Arrays for the order
    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<Chips> chips;

    public Order(){
        this.sandwiches = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.chips = new ArrayList<>();
    }

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public List<Chips> getChips() {
        return chips;
    }

    public void addSandwich(Sandwich sandwich){
        this.sandwiches.add(sandwich);
    }
    public void addDrink(Drink drink){
        this.drinks.add(drink);
    }
    public void addChip(Chips chips){
        this.chips.add(chips);
    }

    @Override
    public double getPrice() {
//        total price for the order
        double totalPrice = 0.0;
        for (Sandwich sandwich : sandwiches){
            totalPrice += sandwich.getPrice();
        }
        for (Drink drink : drinks){
            totalPrice += drink.getPrice();
        }
        for (Chips chips : chips){
            totalPrice += chips.getPrice();
        }
        return totalPrice;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- Your Order Details ---\n");
        if (!sandwiches.isEmpty()) {
            sb.append("Sandwiches:\n");
            for (int i = 0; i < sandwiches.size(); i++) {
                sb.append("Sandwich ").append(i + 1).append(":\n");
                sb.append(sandwiches.get(i).toString());
            }
        }
        if (!drinks.isEmpty()) {
            sb.append("Drinks:\n");
            for (Drink drink : drinks) {
                sb.append("- ").append(drink.toString()).append("\n");
            }
        }
        if (!chips.isEmpty()) {
            sb.append("Chips:\n");
            for (Chips chip : chips) { // Loop adjusted for Chips class
                sb.append("- ").append(chip.toString()).append("\n");
            }
        }
        sb.append(String.format("\nTotal Order Price: $%.2f\n", getPrice()));
        return sb.toString();
    }

}
