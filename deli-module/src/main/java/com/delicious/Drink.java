package com.delicious;

public class Chips implements PricedItem {
    private String type;

    public Chips(String type) {
        this.type = type;
    }

    @Override
    public double getPrice() {
        return 1.25;
    }

    @Override
    public String getName() {
        return type + " chips";
    }
}