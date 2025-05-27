package com.delicious;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptManager {

    // Handles displaying the receipt and saving it
    public void printReceipt(Order order) {
        // Create formatted receipt text
        StringBuilder receipt = new StringBuilder();

        // Add timestamp
        LocalDateTime now = LocalDateTime.now();
        String formattedTime = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        receipt.append("----- RECEIPT -----\n");
        receipt.append("Time: ").append(formattedTime).append("\n\n");

        // Add items
        for (PricedItem item : order.getItems()) {
            receipt.append(item.getName()).append(": $").append(String.format("%.2f", item.getPrice())).append("\n");
        }

        // Add total
        receipt.append("\nTotal: $").append(String.format("%.2f", order.calculateTotal())).append("\n");
        receipt.append("-------------------\n");

        // Display on screen
        System.out.println(receipt);

        // Save to file
        saveToFile(receipt.toString());
    }

    private void saveToFile(String receiptText) {
        try {
            FileWriter writer = new FileWriter("receipt.txt", true); // true = append mode
            writer.write(receiptText + "\n");
            writer.close();
            System.out.println("Receipt saved to receipt.txt\n");
        } catch (IOException e) {
            System.out.println("Failed to save receipt: " + e.getMessage());
        }
    }
}
