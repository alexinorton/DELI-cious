package com.delicious;

public class Chips {
    private String type;  // Doritos, Lays, Sun Chips

    public Chips(String type) {
        this.type = type;
    }

    public double getPrice() {
        return 1.50;
    }

    public String toString() {
        return type + " Chips";
    }
}