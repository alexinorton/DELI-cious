package com.delicious;

import java.util.Scanner;
import com.delicious.Sandwich;
import com.delicious.Drink;
import com.delicious.Chips;
import com.delicious.PricedItem;
import com.delicious.ReceiptManager;
import com.delicious.Order;

public class OrderManager {
    private Scanner scanner;
    private ReceiptManager receiptManager;

    public OrderManager(Scanner scanner, ReceiptManager receiptManager) {
        this.scanner = scanner;
        this.receiptManager = receiptManager;
    }

    public void placeOrder() {
        Order order = new Order();
        boolean ordering = true;

        // keep asking until user finishes
        while (ordering) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add Sandwich");
            System.out.println("2. Add Drink");
            System.out.println("3. Add Chips");
            System.out.println("4. Finish Order");
            System.out.print("Select option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    // Add Sandwich
                    System.out.print("Enter sandwich size (4, 8, or 12): ");
                    String size = scanner.nextLine();
                    System.out.print("Enter bread type: ");
                    String bread = scanner.nextLine();
                    Sandwich sandwich = new Sandwich(size, bread);
                    order.addItem(sandwich);
                    break;

                case 2:
                    // Add Drink
                    System.out.print("Enter drink size (small, medium, large): ");
                    String drinkSize = scanner.nextLine();
                    System.out.print("Enter drink flavor: ");
                    String flavor = scanner.nextLine();
                    Drink drink = new Drink(drinkSize, flavor);
                    order.addItem(drink);
                    break;

                case 3:
                    // Add Chips
                    System.out.print("Enter chip type: ");
                    String chipType = scanner.nextLine();
                    Chips chips = new Chips(chipType);
                    order.addItem(chips);
                    break;

                case 4:
                    ordering = false;
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        double total = order.calculateTotal();

        // Save receipt
        receiptManager.saveReceipts(order.getItems(), total);

        // Print summary
        System.out.println("Order total: $" + total);
    }
}