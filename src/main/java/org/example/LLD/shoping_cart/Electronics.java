package org.example.LLD.shoping_cart;

/**
 * Represents an electronics product.
 * Applies a 10% discount on the unit price.
 */
public class Electronics extends Item {

    private static final double DISCOUNT_RATE = 0.10;

    public Electronics(String name, double price, int quantity) {
        super(name, price, "Electronics", quantity);
    }

    /**
     * Returns the unit price after a 10% electronics discount.
     */
    @Override
    public double applyDiscount() {
        return getPrice() * (1 - DISCOUNT_RATE);
    }
}
