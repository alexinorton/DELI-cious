package com.delicious;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ReceiptManager {

    public void saveReceipts(List<PricedItem> items, double total) {
        LocalDateTime now = LocalDateTime.now();
        String timestamp = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        try (FileWriter writer = new FileWriter("receipts.csv", true)) {
            for (PricedItem item : items) {
                writer.write(timestamp + "," + item.getName() + "," + String.format("%.2f", item.getPrice()) + "\n");
            }
            writer.write(timestamp + ",TOTAL," + String.format("%.2f", total) + "\n");
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }
}