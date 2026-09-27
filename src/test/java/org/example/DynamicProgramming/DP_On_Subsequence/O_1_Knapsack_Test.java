package org.example.DynamicProgramming.DP_On_Subsequence;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class O_1_Knapsack_Test {

    @Test
    @DisplayName("Zero capacity returns zero value")
    void zeroCapacity() {
        // Arrange
        int[] weight = {1, 2, 3};
        int[] value = {10, 20, 30};

        // Act
        int result = O_1_Knapsack.knap_sack(weight, value, 0);

        // Assert
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Empty items array returns zero value")
    void emptyItems() {
        assertEquals(0, O_1_Knapsack.knap_sack(new int[]{}, new int[]{}, 10));
    }

    @Test
    @DisplayName("Single item that fits is taken")
    void singleItemFits() {
        // BUG: method currently returns the item's weight, not its value.
        // With weight=5, value=50, capacity=5, expected max value is 50,
        // but the buggy code returns 5. This test documents correct
        // expected behavior and will fail as-is.
        assertEquals(50, O_1_Knapsack.knap_sack(new int[]{5}, new int[]{50}, 5));
    }

    @Test
    @DisplayName("Single item that doesn't fit is skipped")
    void singleItemDoesNotFit() {
        assertEquals(0, O_1_Knapsack.knap_sack(new int[]{10}, new int[]{100}, 5));
    }

    @Test
    @DisplayName("Classic textbook case: weights {1,3,4,5}, values {1,4,5,7}, capacity 7")
    void classicCase() {
        // BUG: expected optimal value is 9 (items with weight 3+4, value 4+5).
        // The buggy implementation will instead return a weight-based total.
        int[] weight = {1, 3, 4, 5};
        int[] value = {1, 4, 5, 7};
        assertEquals(9, O_1_Knapsack.knap_sack(weight, value, 7));
    }

    @Test
    @DisplayName("All items fit exactly, all should be taken")
    void allItemsFitExactly() {
        int[] weight = {2, 3, 4};
        int[] value = {3, 4, 5};
        // total weight = 9, capacity = 9 -> take everything, value = 12
        assertEquals(12, O_1_Knapsack.knap_sack(weight, value, 9));
    }

    @Test
    @DisplayName("No item fits when capacity is smaller than the smallest weight")
    void noItemFits() {
        int[] weight = {5, 6, 7};
        int[] value = {10, 10, 10};
        assertEquals(0, O_1_Knapsack.knap_sack(weight, value, 4));
    }

    @Test
    @DisplayName("High value low weight item is preferred over low value high weight item")
    void prefersBetterRatio() {
        // capacity only allows one item; item 0 has better value despite similar weight
        int[] weight = {4, 5};
        int[] value = {10, 6};
        assertEquals(10, O_1_Knapsack.knap_sack(weight, value, 4));
    }
}