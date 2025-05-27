package com.delicious;

public interface PricedItem {
    double getPrice();
    String getName(); // Needed for receipt printing
}
