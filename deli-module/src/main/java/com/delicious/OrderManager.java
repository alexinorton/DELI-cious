package com.delicious;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderManager {
    private Scanner scanner;
    private ReceiptManager receiptManager;

    public OrderManager(Scanner scanner, ReceiptManager receiptManager) {
        this.scanner = scanner;
        this.receiptManager = receiptManager;
    }

    public void placeOrder() {
        List<PricedItem> orderItems = new ArrayList<>();

        // Add Sandwich
        System.out.println("Enter sandwich size (4/8/12): ");
        String size = scanner.nextLine();
        System.out.println("Enter bread type: ");
        String bread = scanner.nextLine();
        Sandwich sandwich = new Sandwich(size, bread);
        orderItems.add(sandwich);

        // Add Drink
        System.out.println("Enter drink size (4/8/12): ");
        String drinkSize = scanner.nextLine();
        System.out.println("Enter drink flavor: ");
        String flavor = scanner.nextLine();
        Drink drink = new Drink(drinkSize, flavor);
        orderItems.add(drink);

        // Add Chips
        System.out.println("Enter chip type: ");
        String chipType = scanner.nextLine();
        Chips chips = new Chips(chipType);
        orderItems.add(chips);

        // Calculate total
        double total = 0;
        for (PricedItem item : orderItems) {
            total += item.getPrice();
        }

        // Save receipt
        receiptManager.saveReceipts(orderItems, total);

        // Print summary
        System.out.println("Order total: $" + total);
    }
}