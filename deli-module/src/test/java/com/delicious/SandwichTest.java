package com.delicious;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SandwichTest {

    @Test
    public void testBasicSandwichPrice() {
        Sandwich sandwich = new Sandwich("Wheat", "8");
        sandwich.addMeat("Turkey");
        sandwich.addCheese("Swiss");
        sandwich.addTopping("Lettuce");

        double expectedPrice = 7.00  // base 8"
                + 2.00   // 1 meat
                + 1.50;  // 1 cheese

        assertEquals(expectedPrice, sandwich.getPrice(), 0.01);
    }

    @Test
    public void testExtraOptionsAddCost() {
        Sandwich sandwich = new Sandwich("White", "12");
        sandwich.setExtraMeat(true);
        sandwich.setExtraCheese(true);

        double basePrice = 8.50;
        double extraMeat = 1.50;
        double extraCheese = 0.90;
        double expectedTotal = basePrice + extraMeat + extraCheese;

        assertEquals(expectedTotal, sandwich.getPrice(), 0.01);
    }

    @Test
    public void testToStringContainsBreadAndSize() {
        Sandwich sandwich = new Sandwich("Rye", "4");
        String output = sandwich.toString();
        assertTrue(output.contains("Rye"));
        assertTrue(output.contains("4\""));
    }
}