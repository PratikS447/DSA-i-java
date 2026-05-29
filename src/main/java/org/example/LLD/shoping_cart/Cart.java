package org.example.LLD.shoping_cart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Maintains a collection of Item objects for a single shopping session.
 * Provides add, remove, and read-only access to the item list.
 * All mutation goes through the public API to preserve encapsulation.
 */
public class Cart {

    private final String cartId;
    private final List<Item> items;

    public Cart(String cartId) {
        if (cartId == null || cartId.isBlank())
            throw new IllegalArgumentException("Cart ID cannot be empty.");
        this.cartId = cartId;
        this.items  = new ArrayList<>();
    }

    // ── Mutators ─────────────────────────────────────────────────────────

    /**
     * Adds an item to the cart.
     *
     * @param item the Item to add (must not be null)
     */
    public void addItem(Item item) {
        if (item == null) throw new IllegalArgumentException("Cannot add a null item.");
        items.add(item);
        System.out.println("Added: " + item.getName() + " (x" + item.getQuantity() + ")");
    }

    /**
     * Removes the first item whose name matches (case-insensitive).
     *
     * @param itemName name of the item to remove
     * @throws IllegalArgumentException if no matching item is found
     */

    public void removeItem(String itemName) {
        Item target = items.stream()
                .filter(i -> i.getName().equalsIgnoreCase(itemName))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("Item not found in cart: " + itemName));
        items.remove(target);
        System.out.println("Removed: " + itemName);
    }

    /** Removes all items from the cart. */
    public void clearCart() {
        items.clear();
        System.out.println("Cart cleared.");
    }

    // ── Accessors ────────────────────────────────────────────────────────

    /**
     * Returns an unmodifiable view of the cart's items.
     * Callers cannot add or remove through this reference.
     */
    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }

    public String getCartId() { return cartId; }

    public boolean isEmpty() { return items.isEmpty(); }

    public int size() { return items.size(); }
}
