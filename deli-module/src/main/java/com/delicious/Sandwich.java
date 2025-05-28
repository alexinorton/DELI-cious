package com.delicious;

public class Sandwich implements PricedItem {
    private String size;
    private String bread;
    private double price;

    public Sandwich(String size, String bread) {
        this.size = size;
        this.bread = bread;
        this.price = calculatePrice(size);
    }

    private double calculatePrice(String size) {
        switch (size) {
            case "4":
                return 5.00;
            case "8":
                return 7.00;
            case "12":
                return 9.00;
            default:
                return 7.00; // Default price if size is unknown
        }
    }

    @Override
    public String getName() {
        return size + " inch " + bread + " Sandwich";
    }

    @Override
    public double getPrice() {
        return price;
    }
}