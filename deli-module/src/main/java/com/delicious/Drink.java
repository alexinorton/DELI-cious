package com.delicious;

public class Drink implements PricedItem {
    private String size;
    private String flavor;

    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    @Override
    public double getPrice() {
        switch (size.toLowerCase()) {
            case "small":
                return 1.50;
            case "medium":
                return 2.00;
            case "large":
                return 2.50;
            default:
                return 0.00;
        }
    }

    @Override
    public String getName() {
        return size + " " + flavor + " drink";
    }
}
