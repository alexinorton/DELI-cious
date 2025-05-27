package com.delicious;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Start scanner
        Scanner scanner = new Scanner(System.in);
        ReceiptManager receiptManager = new ReceiptManager();
        OrderManager orderManager = new OrderManager(scanner, receiptManager);

        // Place an order
        orderManager.placeOrder();

        scanner.close();
    }
}