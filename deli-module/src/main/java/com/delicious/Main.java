package com.delicious;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderManager orderManager = new OrderManager();
        ReceiptManager receiptManager = new ReceiptManager();
        Order order = new Order();

        System.out.println("Welcome to DELI-cious Sandwich Shop!");

        // Sandwich
        Sandwich sandwich = orderManager.buildSandwich(scanner);
        order.addSandwich(sandwich);

        // Drink
        System.out.println("Would you like a drink? (yes/no)");
        String drinkChoice = scanner.nextLine();
        if (drinkChoice.equalsIgnoreCase("yes")) {
            Drink drink = orderManager.buildDrink(scanner);
            order.addDrink(drink);
        }

        // Chips
        System.out.println("Would you like chips? (yes/no)");
        String chipChoice = scanner.nextLine();
        if (chipChoice.equalsIgnoreCase("yes")) {
            Chips chips = orderManager.buildChips(scanner);
            order.addChips(chips);
        }

        // Display order and save receipt
        System.out.println("\n--- Final Order ---");
        System.out.println(order);

        receiptManager.saveReceipt(order);
        System.out.println("Thank you for your order!");

        scanner.close();
    }
}