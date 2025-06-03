package com.pluralsight.model;

import java.util.ArrayList;
import java.util.List;

public class Sandwich implements Priceable{
    private String size = "";
    // "white", "wheat", "rye", "wrap"
    private String breadType;
    private boolean toasted;
    // Allow multiple meats
    private List<Meat> meats;
    // Allow multiple cheeses
    private List<Cheese> cheese;
    private List<RegularTopping> regularToppings;
    private List<Sauce> sauce;

    public Sandwich(String size, String breadType) {
        this.size = size;
        this.breadType = breadType;
        this.toasted = false;
        this.meats = new ArrayList<>();
        this.cheese = new ArrayList<>();
        this.regularToppings = new ArrayList<>();
        this.sauce = new ArrayList<>();
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }
    public void addMeat(String name, boolean isExtra){
        this.meats.add(new Meat(name, this.size, isExtra));
    }
    public void addCheese(String name, boolean isExtra){
        this.cheese.add(new Cheese(name, this.size, isExtra));
    }
    public void addRegularTopping(String name){
        this.regularToppings.add(new RegularTopping(name));
    }
    public void addSauce(String name){
        this.sauce.add(new Sauce(name));
    }

    @Override
    public double getPrice() {
        double price = 0.0;

        if (size.equals("4")){
            price += 5.50;
        } else if (size.equals("8")) {
            price += 7.00;
        } else if (size.equals("12")) {
            price += 8.50;
        }


        for (Meat meat : meats){
            price += meat.getPrice();
        }
        for (Cheese cheese: cheese){
            price += cheese.getPrice();
        }
        return price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("   Size: ").append(size).append("\n");
        sb.append("   Bread: ").append(breadType).append("\n");
        if (toasted) {
            sb.append("   Toasted: Yes\n");
        }
        if (!meats.isEmpty()) {
            sb.append("   Meats: ");
            for (int i = 0; i < meats.size(); i++) {
                sb.append(meats.get(i).getName());
                if (meats.get(i).isExtra) {
                    sb.append(" (Extra)");
                }
                if (i < meats.size() - 1) {
                    sb.append(", ");
                }
            }
            sb.append("\n");
        }
        if (!cheese.isEmpty()) {
            sb.append("   Cheeses: ");
            for (int i = 0; i < cheese.size(); i++) {
                sb.append(cheese.get(i).getName());
                if (cheese.get(i).isExtra) {
                    sb.append(" (Extra)");
                }
                if (i < cheese.size() - 1) {
                    sb.append(", ");
                }
            }
            sb.append("\n");
        }
        if (!regularToppings.isEmpty()) {
            sb.append("   Other Toppings: ").append(String.join(", ", regularToppings.stream().map(Topping::getName).collect(java.util.stream.Collectors.toList()))).append("\n");
        }
        if (!sauce.isEmpty()) {
            sb.append("   Sauces: ").append(String.join(", ", sauce.stream().map(Topping::getName).collect(java.util.stream.Collectors.toList()))).append("\n");
        }
        sb.append(String.format("   Sandwich Price: $%.2f\n", getPrice()));
        return sb.toString();
    }
}
