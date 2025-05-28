package com.delicious;

public class Chips implements PricedItem {
    private String type;
    private double price;

    public Chips(String type) {
        this.type = type;
        this.price = 1.50; // Flat price for chips
    }

    @Override
    public String getName() {
        return type + " Chips";
    }

    @Override
    public double getPrice() {
        return price;
    }
}