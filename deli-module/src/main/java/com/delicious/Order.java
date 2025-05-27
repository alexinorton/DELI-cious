package com.delicious;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<PricedItem> items;

    public Order() {
        this.items = new ArrayList<>();
    }

    // Add an item to the order
    public void addItem(PricedItem item) {
        items.add(item);
    }

    // Get the list of items
    public List<PricedItem> getItems() {
        return items;
    }

    // Calculate the total price
    public double calculateTotal() {
        double total = 0;
        for (PricedItem item : items) {
            total += item.getPrice();
        }
        return total;
    }
}