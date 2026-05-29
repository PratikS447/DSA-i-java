package org.example.LLD.shoping_cart;

/**
 * Represents a clothing product.
 * Applies a 20% discount on the unit price.
 */
public class Clothing extends Item {

    private static final double DISCOUNT_RATE = 0.20;

    public Clothing(String name, double price, int quantity) {
        super(name, price, "Clothing", quantity);
    }

    /**
     * Returns the unit price after a 20% clothing discount.
     */
    @Override
    public double applyDiscount() {
        return getPrice() * (1 - DISCOUNT_RATE);
    }
}
