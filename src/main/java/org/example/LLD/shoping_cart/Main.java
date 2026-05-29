package org.example.LLD.shoping_cart;

import java.util.List;

/**
 * Entry point — demonstrates the shopping cart system end-to-end.
 * Shows adding items across all three categories, polymorphic discount
 * calculation, category filtering, item removal, and receipt printing.
 */
public class Main {

    public static void main(String[] args) {

        // ── 1. Set up cart and manager ─────────────────────────────────────
        Cart cart= new Cart("CART-2024-001");
        CartManager manager = new CartManager(cart);

        System.out.println("=== Shopping Cart System Demo ===\n");

        // ── 2. Add items from all three categories ─────────────────────────
        manager.addItemToCart(new Electronics("Laptop",        999.99, 1));
        manager.addItemToCart(new Electronics("Wireless Mouse",  29.99, 2));
        manager.addItemToCart(new Clothing("Winter Jacket",   89.99, 1));
        manager.addItemToCart(new Clothing("Running Shoes",   59.99, 2));
        manager.addItemToCart(new Grocery("Organic Milk",     3.49, 4));
        manager.addItemToCart(new Grocery("Whole Wheat Bread",2.99, 2));

        // ── 3. Print the full receipt ──────────────────────────────────────
        manager.printReceipt();

        // ── 4. Filter by category (polymorphism in action) ─────────────────
        System.out.println("--- Electronics in cart ---");
        List<Item> electronics = manager.getItemsByCategory("Electronics");
        electronics.forEach(System.out::println);

        System.out.println("\n--- Clothing in cart ---");
        List<Item> clothing = manager.getItemsByCategory("Clothing");
        clothing.forEach(System.out::println);

        // ── 5. Remove an item then reprint ─────────────────────────────────
        System.out.println("\n--- Removing 'Winter Jacket' ---");
        manager.removeItemFromCart("Winter Jacket");
        manager.printReceipt();

        // ── 6. Demonstrate error handling ──────────────────────────────────
        System.out.println("--- Attempting to remove a non-existent item ---");
        try {
            manager.removeItemFromCart("Gaming Chair");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected error: " + e.getMessage());
        }
    }
}
