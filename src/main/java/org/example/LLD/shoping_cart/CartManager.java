package org.example.LLD.shoping_cart;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Orchestrates all business operations on a Cart:
 * adding/removing items, calculating totals, printing receipts,
 * and filtering items by category.
 *
 * CartManager depends on Cart (composition) and operates on
 * Item references polymorphically — it never checks item types directly.
 */
public class CartManager {

    private final Cart cart;

    public CartManager(Cart cart) {
        if (cart == null) throw new IllegalArgumentException("Cart cannot be null.");
        this.cart = cart;
    }

    // ── Delegation to Cart ────────────────────────────────────────────────

    /** Adds an item to the underlying cart. */
    public void addItemToCart(Item item) {
        cart.addItem(item);
    }

    /** Removes an item by name from the underlying cart. */
    public void removeItemFromCart(String itemName) {
        cart.removeItem(itemName);
    }

    /** Clears all items from the cart. */
    public void clearCart() {
        cart.clearCart();
    }

    // ── Business logic ────────────────────────────────────────────────────

    /**
     * Calculates the grand total of all items after their respective discounts.
     * Polymorphism means applyDiscount() resolves to the correct subclass
     * implementation at runtime — no instanceof or switch needed.
     *
     * @return total price as a double
     */
    public double calculateTotal() {
        return cart.getItems()
                .stream()
                .mapToDouble(Item::getSubtotal)
                .sum();
    }

    /**
     * Returns all items belonging to a given category (case-insensitive).
     *
     * @param category e.g. "Electronics", "Clothing", "Grocery"
     */
    public List<Item> getItemsByCategory(String category) {
        return cart.getItems()
                .stream()
                .filter(i -> i.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    /**
     * Prints a formatted receipt to stdout showing each item's
     * discounted price and the grand total.
     */
    public void printReceipt() {
        System.out.println("\n╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║                   SHOPPING CART RECEIPT                     ║");
        System.out.println("║  Cart ID: " + String.format("%-51s", cart.getCartId()) + "║");
        System.out.println("╠══════════════════════════════════════════════════════════════╣");
        System.out.printf("║  %-20s %-12s %5s  %8s  %9s ║%n",
                "Item", "Category", "Qty", "Unit ($)", "Total ($)");
        System.out.println("╠══════════════════════════════════════════════════════════════╣");

        if (cart.isEmpty()) {
            System.out.println("║  Cart is empty.                                              ║");
        } else {
            for (Item item : cart.getItems()) {
                System.out.printf("║  %-20s %-12s %5d  %8.2f  %9.2f ║%n",
                        item.getName(),
                        item.getCategory(),
                        item.getQuantity(),
                        item.applyDiscount(),
                        item.getSubtotal());
            }
        }

        System.out.println("╠══════════════════════════════════════════════════════════════╣");
        System.out.printf("║  %-44s %9.2f ║%n", "GRAND TOTAL ($):", calculateTotal());
        System.out.println("╚══════════════════════════════════════════════════════════════╝\n");
    }
}
