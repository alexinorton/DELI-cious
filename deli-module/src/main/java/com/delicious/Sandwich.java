package com.delicious;

public class Sandwich implements PricedItem {
    private String size;
    private String bread;

    public Sandwich(String size, String bread) {
        this.size = size;
        this.bread = bread;
    }

    @Override
    public double getPrice() {
        switch (size) {
            case "4": return 5.50;
            case "8": return 7.00;
            case "12": return 8.50;
            default: return 0.00;
        }
    }

    @Override
    public String getName() {
        return size + " inch " + bread + " sandwich";
    }
}