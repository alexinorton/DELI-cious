package com.delicious;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Sandwich> sandwiches = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();
    private List<Chips> chips = new ArrayList<>();

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void addChips(Chips chip) {
        chips.add(chip);
    }

    public double getTotalPrice() {
        double total = 0.0;
        for (Sandwich s : sandwiches) {
            total += s.getPrice();
        }
        for (Drink d : drinks) {
            total += d.getPrice();
        }
        for (Chips c : chips) {
            total += c.getPrice();
        }
        return total;
    }

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public List<Chips> getChips() {
        return chips;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order Summary:\n\n");

        for (Sandwich s : sandwiches) {
            sb.append(s.toString()).append("\n\n");
        }
        for (Drink d : drinks) {
            sb.append("Drink: ").append(d.toString()).append("\n");
        }
        for (Chips c : chips) {
            sb.append("Chips: ").append(c.toString()).append("\n");
        }

        sb.append("\nTotal: $").append(String.format("%.2f", getTotalPrice()));
        return sb.toString();
    }
}