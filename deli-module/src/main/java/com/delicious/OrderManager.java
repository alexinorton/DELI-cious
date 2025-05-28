package com.delicious;

import java.util.Scanner;

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

        while (ordering) {
            System.out.println("\n=== ORDER MENU ===");
            System.out.println("1. Add Sandwich");
            System.out.println("2. Add Drink");
            System.out.println("3. Add Chips");
            System.out.println("4. Finish Order");
            System.out.print("Choose an option: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.println("What size sandwich would you like?");
                    System.out.println("Options: 4 inch, 8 inch, 12 inch");
                    System.out.print("Enter size: ");
                    String size = scanner.nextLine();

                    System.out.println("Choose your bread:");
                    System.out.println("1. White");
                    System.out.println("2. Wheat");
                    System.out.println("3. Rye");
                    System.out.println("4. Wrap");
                    System.out.println("Or type your own:");
                    System.out.print("Enter bread: ");
                    String breadChoice = scanner.nextLine();
                    String bread;

                    switch (breadChoice) {
                        case "1":
                            bread = "White";
                            break;
                        case "2":
                            bread = "Wheat";
                            break;
                        case "3":
                            bread = "Rye";
                            break;
                        case "4":
                            bread = "Wrap";
                            break;
                        default:
                            bread = breadChoice;
                            break;
                    }

                    Sandwich sandwich = new Sandwich(size, bread);
                    order.addItem(sandwich);
                    System.out.println("Sandwich added!");
                    break;

                case "2":
                    System.out.println("Choose your drink size:");
                    System.out.println("1. Small");
                    System.out.println("2. Medium");
                    System.out.println("3. Large");
                    System.out.print("Enter choice: ");
                    String drinkSizeInput = scanner.nextLine();
                    String drinkSize;

                    switch (drinkSizeInput) {
                        case "1":
                            drinkSize = "Small";
                            break;
                        case "2":
                            drinkSize = "Medium";
                            break;
                        case "3":
                            drinkSize = "Large";
                            break;
                        default:
                            drinkSize = drinkSizeInput;
                            break;
                    }

                    System.out.print("Enter drink flavor: ");
                    String flavor = scanner.nextLine();
                    Drink drink = new Drink(drinkSize, flavor);
                    order.addItem(drink);
                    System.out.println("Drink added!");
                    break;

                case "3":
                    System.out.println("Choose your chips:");
                    System.out.println("1. Classic");
                    System.out.println("2. BBQ");
                    System.out.println("3. Sour Cream & Onion");
                    System.out.println("4. Jalapeno");
                    System.out.println("Or type your own chip type.");
                    System.out.print("Enter chip choice: ");
                    String chipInput = scanner.nextLine();
                    String chipType;

                    switch (chipInput) {
                        case "1":
                            chipType = "Classic";
                            break;
                        case "2":
                            chipType = "BBQ";
                            break;
                        case "3":
                            chipType = "Sour Cream & Onion";
                            break;
                        case "4":
                            chipType = "Jalapeno";
                            break;
                        default:
                            chipType = chipInput;
                            break;
                    }

                    Chips chips = new Chips(chipType);
                    order.addItem(chips);
                    System.out.println("Chips added!");
                    break;

                case "4":
                    ordering = false;
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            }
        }

        double total = order.calculateTotal();
        receiptManager.saveReceipts(order.getItems(), total);
        System.out.println("Order complete! Total: $" + String.format("%.2f", total));
    }
}