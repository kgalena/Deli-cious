package com.pluralsight.ui;

import com.pluralsight.filemanager.FileManager;
import com.pluralsight.model.Chips;
import com.pluralsight.model.Drink;
import com.pluralsight.model.Order;
import com.pluralsight.model.Sandwich;

import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner;
    private Order currentOrder;

    public UserInterface(){
        this.scanner = new Scanner(System.in);
    }
    private void displayHomeScreen() {
        System.out.println("\n--- Home Screen ---");
        System.out.println("1) New Order");
        System.out.println("0) Exit");
        System.out.print("Enter your choice: ");
    }
    public void mainApp() {
        while (true) {
            displayHomeScreen();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    NewOrder();
                    break;
                case "0":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid! Try again.");
            }
        }
    }
    private void orderScreen() {
        System.out.println("\n--- Order Screen ---");
        System.out.println("1) Add Sandwich");
        System.out.println("2) Add Drink");
        System.out.println("3) Add Chips");
        System.out.println("4) Checkout");
        System.out.println("0) Cancel Order");
        System.out.print("Enter your choice: ");
    }
    private void NewOrder() {
        currentOrder = new Order();
        while (true) {
            orderScreen();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addSandwich();
                    break;
                case "2":
                    addDrink();
                    break;
                case "3":
                    addChips();
                    break;
                case "4":
                    checkout();
                    return; // Exit 
                case "0":
                    System.out.println("Order cancelled.");
                    currentOrder = null; // to remove the order
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void addSandwich() {
        System.out.println("\n--- Add Sandwich ---");
        String breadType;
        while (true) {
            System.out.print("Select your bread (white, wheat, rye, wrap): ");
            breadType = scanner.nextLine();
            if (breadType.equalsIgnoreCase("white") || breadType.equalsIgnoreCase("wheat") || breadType.equalsIgnoreCase("rye") || breadType.equalsIgnoreCase("wrap")) {
                break;
            } else {
                System.out.println("Invalid bread type. Please choose from white, wheat, rye, or wrap.");
            }
        }
        String size;
        while (true) {
            System.out.print("Select sandwich size (4, 8, 12): ");
            size = scanner.nextLine();
            if (size.equals("4") || size.equals("8") || size.equals("12")) {
                break;
            } else {
                System.out.println("Invalid size. Please choose from 4\", 8\", or 12\".");
            }
        }

        Sandwich sandwich = new Sandwich(size, breadType);
        while (true) {
            System.out.print("Add Meat (steak, ham, salami, roast beef, chicken, bacon) or 'done': ");
            String meatChoice = scanner.nextLine();
            if (meatChoice.equals("done")) {
                break;
            }
            if (meatChoice.equalsIgnoreCase("steak") || meatChoice.equalsIgnoreCase("ham") || meatChoice.equalsIgnoreCase("salami") ||
                    meatChoice.equalsIgnoreCase("roast beef") || meatChoice.equalsIgnoreCase("chicken") || meatChoice.equalsIgnoreCase("bacon")) {
                System.out.print("Add extra " + meatChoice + "? (yes/no): ");
                boolean extraMeat = scanner.nextLine().equalsIgnoreCase("yes");

                sandwich.addMeat(meatChoice, extraMeat);
            } else {
                System.out.println("Invalid meat choice. Please try again.");
            }
        }
        while (true) {
            System.out.print("Add Cheese (american, provolone, cheddar, swiss) or 'done': ");
            String cheeseChoice = scanner.nextLine();
            if (cheeseChoice.equalsIgnoreCase("done")) {
                break;
            }
            if (cheeseChoice.equals("american") || cheeseChoice.equals("provolone") || cheeseChoice.equals("cheddar") || cheeseChoice.equals("swiss")) {
                System.out.print("Add extra " + cheeseChoice + "? (yes/no): ");
                boolean extraCheese = scanner.nextLine().equalsIgnoreCase("yes");

                sandwich.addCheese(cheeseChoice, extraCheese);
            } else {
                System.out.println("Invalid cheese choice. Please try again.");
            }
        }
        while (true) {
            System.out.print("Add Other Topping (lettuce, peppers, onions, tomatoes, jalapeños, cucumbers, pickles, guacamole, mushrooms) or 'done': ");
            String toppingChoice = scanner.nextLine();
            if (toppingChoice.equalsIgnoreCase("done")) {
                break;
            }
            if (toppingChoice.equalsIgnoreCase("lettuce") || toppingChoice.equalsIgnoreCase("peppers") || toppingChoice.equalsIgnoreCase("onions") ||
                    toppingChoice.equalsIgnoreCase("tomatoes") || toppingChoice.equalsIgnoreCase("jalapeños") || toppingChoice.equalsIgnoreCase("cucumbers") ||
                    toppingChoice.equalsIgnoreCase("pickles") || toppingChoice.equalsIgnoreCase("guacamole") || toppingChoice.equalsIgnoreCase("mushrooms")) {

                sandwich.addRegularTopping(toppingChoice);
            } else {
                System.out.println("Invalid topping choice. Please try again.");
            }
        }
        while (true) {
            System.out.print("Select Sauce (mayo, mustard, ketchup, ranch, thousand islands, vinaigrette, au jus sauce) or 'done': ");
            String sauceChoice = scanner.nextLine();
            if (sauceChoice.equalsIgnoreCase("done")) {
                break;
            }

            if (sauceChoice.equalsIgnoreCase("mayo") || sauceChoice.equalsIgnoreCase("mustard") || sauceChoice.equalsIgnoreCase("ketchup") ||
                    sauceChoice.equalsIgnoreCase("ranch") || sauceChoice.equalsIgnoreCase("thousand islands") || sauceChoice.equalsIgnoreCase("vinaigrette") ||
                    sauceChoice.equalsIgnoreCase("au jus sauce")) {

                sandwich.addSauce(sauceChoice);
            } else {
                System.out.println("Invalid sauce choice. Please try again.");
            }
        }

        System.out.print("Would you like the sandwich toasted? (yes/no): ");
        boolean toastedChoice = scanner.nextLine().equalsIgnoreCase("yes");
        sandwich.setToasted(toastedChoice);

        currentOrder.addSandwich(sandwich);
        System.out.println("Sandwich added to order!");
    }
    private void addDrink() {
        System.out.println("\n--- Add Drink ---");
        String flavor;
        while (true) {
            System.out.print("Enter drink flavor (e.g., Coke, Sprite, Water): ");
            flavor = scanner.nextLine();
            if (!flavor.trim().isEmpty()) {
                break;
            } else {
                System.out.println("Drink flavor cannot be empty.");
            }
        }

        String size;
        while (true) {
            System.out.print("Select drink size (Small, Medium, Large): ");
            size = scanner.nextLine();
            if (size.equalsIgnoreCase("Small") || size.equalsIgnoreCase("Medium") || size.equalsIgnoreCase("Large")) {
                break;
            } else {
                System.out.println("Invalid size. Please choose from Small, Medium, or Large.");
            }
        }

        currentOrder.addDrink(new Drink(size, flavor));
        System.out.println("Drink added to order!");
    }

    private void addChips() {
        System.out.println("\n--- Add Chips ---");
        String chipType;
        while (true) {
            System.out.print("Enter chip type (e.g., BBQ, Salt & Vinegar, Plain): ");
            chipType = scanner.nextLine();
            if (!chipType.trim().isEmpty()) {
                break;
            } else {
                System.out.println("Chip type cannot be empty.");
            }
        }

        currentOrder.addChip(new Chips(chipType));
        System.out.println("Chips added to order!");
    }

    private void checkout() {
        System.out.println("\n--- Checkout ---");

        System.out.println(currentOrder.toString());

        System.out.print("Confirm order? (yes/no): ");
        String confirmChoice = scanner.nextLine();

        if (confirmChoice.equals("yes")) {
            FileManager.saveReceipt(currentOrder);
            System.out.println("Order confirmed and receipt saved. Returning to Home Screen.");
            currentOrder = null;
        } else {
            System.out.println("Order cancelled. Returning to Home Screen.");
            currentOrder = null;
        }
    }
}
