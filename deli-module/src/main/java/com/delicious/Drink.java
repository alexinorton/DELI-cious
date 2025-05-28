package com.delicious;

public class Drink implements PricedItem {
    private String size;
    private String flavor;
    private double price;

    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
        this.price = calculatePrice(size);
    }

    private double calculatePrice(String size) {
        switch (size.toLowerCase()) {
            case "small":
                return 1.50;
            case "medium":
                return 2.00;
            case "large":
                return 2.50;
            default:
                return 2.00; // Default price
        }
    }

    @Override
    public String getName() {
        return size + " " + flavor + " Drink";
    }

    @Override
    public double getPrice() {
        return price;
    }
}
