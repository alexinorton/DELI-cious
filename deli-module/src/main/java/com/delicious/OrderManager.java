package com.delicious;

import java.util.Scanner;

public class OrderManager {

    public Sandwich buildSandwich(Scanner scanner) {
        System.out.println("Choose sandwich size (4, 8, 12):");
        String size = scanner.nextLine();

        while (!size.equals("4") && !size.equals("8") && !size.equals("12")) {
            System.out.println("Invalid size. Please enter 4, 8, or 12:");
            size = scanner.nextLine();
        }

        System.out.println("Choose bread type (White, Wheat, Rye, Wrap):");
        String bread = scanner.nextLine();

        Sandwich sandwich = new Sandwich(bread, size);

        System.out.println("Add meats (type one at a time, 'done' to finish):");
        while (true) {
            String meat = scanner.nextLine();
            if (meat.equalsIgnoreCase("done")) break;
            sandwich.addMeat(meat);
        }

        System.out.println("Add cheeses (type one at a time, 'done' to finish):");
        while (true) {
            String cheese = scanner.nextLine();
            if (cheese.equalsIgnoreCase("done")) break;
            sandwich.addCheese(cheese);
        }

        System.out.println("Add regular toppings (lettuce, tomato, etc). Type 'done' to finish:");
        while (true) {
            String topping = scanner.nextLine();
            if (topping.equalsIgnoreCase("done")) break;
            sandwich.addTopping(topping);
        }

        System.out.println("Would you like extra meat? (yes/no)");
        String extraMeat = scanner.nextLine();
        sandwich.setExtraMeat(extraMeat.equalsIgnoreCase("yes"));

        System.out.println("Would you like extra cheese? (yes/no)");
        String extraCheese = scanner.nextLine();
        sandwich.setExtraCheese(extraCheese.equalsIgnoreCase("yes"));

        return sandwich;
    }

    public Drink buildDrink(Scanner scanner) {
        System.out.println("Choose a drink type (Coffee, Apple Juice, Water, Soda):");
        String type = scanner.nextLine();

        System.out.println("Choose a drink size (Small, Medium, Large):");
        String size = scanner.nextLine();

        return new Drink(type, size);
    }

    public Chips buildChips(Scanner scanner) {
        System.out.println("Choose chip type (Doritos, Lays, Sun Chips):");
        String type = scanner.nextLine();

        return new Chips(type);
    }
}
