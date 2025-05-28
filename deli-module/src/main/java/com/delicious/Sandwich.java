package com.delicious;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private String breadType;
    private String size; // 4", 8", 12"
    private List<String> meats = new ArrayList<>();
    private List<String> cheeses = new ArrayList<>();
    private List<String> regularToppings = new ArrayList<>();
    private boolean extraMeat = false;
    private boolean extraCheese = false;

    public Sandwich(String breadType, String size) {
        this.breadType = breadType;
        this.size = size;
    }

    public void addMeat(String meat) {
        meats.add(meat);
    }

    public void addCheese(String cheese) {
        cheeses.add(cheese);
    }

    public void addTopping(String topping) {
        regularToppings.add(topping);
    }

    public void setExtraMeat(boolean extraMeat) {
        this.extraMeat = extraMeat;
    }

    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

    public double getPrice() {
        double basePrice = switch (size) {
            case "4" -> 5.50;
            case "8" -> 7.00;
            case "12" -> 8.50;
            default -> 0.0;
        };

        int meatCount = meats.size();
        double meatCost = meatCount * switch (size) {
            case "4" -> 1.00;
            case "8" -> 2.00;
            case "12" -> 3.00;
            default -> 0.0;
        };

        int cheeseCount = cheeses.size();
        double cheeseCost = cheeseCount * switch (size) {
            case "4" -> 0.75;
            case "8" -> 1.50;
            case "12" -> 2.25;
            default -> 0.0;
        };

        double extraMeatCost = extraMeat ? switch (size) {
            case "4" -> 0.50;
            case "8" -> 1.00;
            case "12" -> 1.50;
            default -> 0.0;
        } : 0.0;

        double extraCheeseCost = extraCheese ? switch (size) {
            case "4" -> 0.30;
            case "8" -> 0.60;
            case "12" -> 0.90;
            default -> 0.0;
        } : 0.0;

        return basePrice + meatCost + cheeseCost + extraMeatCost + extraCheeseCost;
    }

    public String toString() {
        return size + "\" " + breadType + " Sandwich\nMeats: " + meats +
                "\nCheeses: " + cheeses +
                "\nToppings: " + regularToppings +
                (extraMeat ? "\nExtra Meat" : "") +
                (extraCheese ? "\nExtra Cheese" : "");
    }
}