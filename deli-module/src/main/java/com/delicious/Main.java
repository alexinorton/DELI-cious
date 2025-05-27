package com.delicious;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("=== Welcome to DELI-cious ===");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Starting new order...");
                    startOrder(scanner);
                    break;
                case "0":
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void startOrder(Scanner scanner) {
        boolean ordering = true;
        Order order = new Order();

        while (ordering) {
            System.out.println("\n=== Order Menu ===");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.print("Choose an option: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    addSandwich(scanner, order);
                    break;
                case "2":
                    addDrink(scanner, order);
                    break;
                case "3":
                    System.out.println("Add Chips (coming soon)");
                    break;
                case "4":
                    System.out.println("Checkout (coming soon)");
                    ordering = false;
                    break;
                case "0":
                    System.out.println("Order canceled.");
                    ordering = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    public static void addSandwich(Scanner scanner, Order order) {
        System.out.println("Select bread type (white, wheat, rye, wrap): ");
        String bread = scanner.nextLine();

        System.out.println("Select sandwich size (4, 8, 12): ");
        String size = scanner.nextLine();

        Sandwich sandwich = new Sandwich(size, bread);
        order.addSandwich(sandwich);

        System.out.println("Sandwich added: " + size + "\" " + bread);
    }

    public static void addDrink(Scanner scanner, Order order) {
        System.out.println("Select drink size (Small, Medium, Large): ");
        String size = scanner.nextLine();

        System.out.println("Enter drink flavor: ");
        String flavor = scanner.nextLine();

        Drink drink = new Drink(size, flavor);
        order.addDrink(drink);

        System.out.println("Drink added: " + size + " " + flavor);
    }
}
