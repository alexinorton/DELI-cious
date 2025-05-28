package com.delicious;

public class Drink {
    private String type;  // Coffee, Apple Juice, Water, Soda
    private String size;  // Small, Medium, Large

    public Drink(String type, String size) {
        this.type = type;
        this.size = size;
    }

    public double getPrice() {
        return switch (size.toLowerCase()) {
            case "small" -> 2.00;
            case "medium" -> 2.50;
            case "large" -> 3.00;
            default -> 0.0;
        };
    }

    public String toString() {
        return size + " " + type;
    }
}
