package org.example.LLD.shoping_cart;

/**
 * Represents a grocery product.
 * No discount applied — price is sold at full value.
 */
public class Grocery extends Item {

    public Grocery(String name, double price, int quantity) {
        super(name, price, "Grocery", quantity);
    }

    /**
     * Returns the full unit price (no discount for groceries).
     */
    @Override
    public double applyDiscount() {
        return getPrice();
    }
}
