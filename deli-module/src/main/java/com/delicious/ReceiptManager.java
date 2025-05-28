package com.delicious;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class ReceiptManager {

    public void saveReceipt(Order order) {
        String txtPath = "receipt.txt";
        String csvPath = "receipt.csv";

        try {
            FileWriter txtWriter = new FileWriter(txtPath);
            txtWriter.write("RECEIPT - " + LocalDateTime.now() + "\n\n");
            txtWriter.write(order.toString());
            txtWriter.close();

            FileWriter csvWriter = new FileWriter(csvPath);
            csvWriter.write("Type,Item,Price\n");

            for (Sandwich s : order.getSandwiches()) {
                csvWriter.write("Sandwich,\"" + s.toString().replace("\n", ";") + "\"," + s.getPrice() + "\n");
            }

            for (Drink d : order.getDrinks()) {
                csvWriter.write("Drink," + d.toString() + "," + d.getPrice() + "\n");
            }

            for (Chips c : order.getChips()) {
                csvWriter.write("Chips," + c.toString() + "," + c.getPrice() + "\n");
            }

            csvWriter.write(",,\nTotal,," + order.getTotalPrice());
            csvWriter.close();

            System.out.println("Receipt saved to receipt.txt and receipt.csv");

        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }
}