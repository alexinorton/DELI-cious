package com.delicious;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptManager {

    public void saveReceipt(Order order) {
        String folderName = "receipts";
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
        String fileName = folderName + "/" + timestamp + ".txt";

        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write("=== DELI-cious Receipt ===\n\n");

            writer.write("Sandwiches:\n");
            for (Sandwich sandwich : order.getSandwiches()) {
                writer.write("- " + sandwich.getPrice() + "\n");
            }

            writer.write("\nDrinks:\n");
            for (Drink drink : order.getDrinks()) {
                writer.write("- " + drink.getPrice() + "\n");
            }

            writer.write("\nChips:\n");
            for (Chips chip : order.getChips()) {
                writer.write("- " + chip.getPrice() + "\n");
            }

            writer.write("\nTotal: $" + order.getTotalPrice());

            writer.close();
            System.out.println("Receipt saved as: " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }
}
