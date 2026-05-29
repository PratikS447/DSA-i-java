package org.example.LLD.shoping_cart;

/**
 * Abstract base class representing a product in the shopping cart system.
 * Encapsulates common product attributes and enforces a discount contract
 * on all subclasses via the abstract applyDiscount() method.
 */
public abstract class Item {

    private String name;
    private double price;
    private String category;
    private int quantity;

    /**
     * Constructs an Item with all required attributes.
     *
     * @param name     the product name
     * @param price    the unit price (must be >= 0)
     * @param category the product category label
     * @param quantity the number of units (must be >= 1)
     */
    public Item(String name, double price, String category, int quantity) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name cannot be empty.");
        if (price < 0)    throw new IllegalArgumentException("Price cannot be negative.");
        if (quantity < 1) throw new IllegalArgumentException("Quantity must be at least 1.");

        this.name     = name;
        this.price    = price;
        this.category = category;
        this.quantity = quantity;
    }

    // ── Getters ──────────────────────────────────────────────────────────

    public String getName()     { return name; }
    public double getPrice()    { return price; }
    public String getCategory() { return category; }
    public int    getQuantity() { return quantity; }

    // ── Setters ──────────────────────────────────────────────────────────

    public void setName(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name cannot be empty.");
        this.name = name;
    }

    public void setPrice(double price) {
        if (price < 0) throw new IllegalArgumentException("Price cannot be negative.");
        this.price = price;
    }

    public void setQuantity(int quantity) {
        if (quantity < 1) throw new IllegalArgumentException("Quantity must be at least 1.");
        this.quantity = quantity;
    }

    // ── Business logic ───────────────────────────────────────────────────

    /**
     * Returns the discounted unit price for this item.
     * Each subclass defines its own discount policy (polymorphism).
     */
    public abstract double applyDiscount();

    /**
     * Returns price × quantity using the discounted unit price.
     */
    public double getSubtotal() {
        return applyDiscount() * quantity;
    }

    @Override
    public String toString() {
        return String.format("%-20s | %-12s | Qty: %2d | Unit: $%6.2f | Subtotal: $%7.2f",
                name, category, quantity, applyDiscount(), getSubtotal());
    }
}
