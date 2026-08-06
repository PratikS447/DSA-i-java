package org.example.HashMap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Cold_DrinkTest {
    @Test
    void testStandardCase() {
        int[] arr = {1, 1, 2, 2, 3, 3, 4, 5};
        int k = 3;
        // Smallest window with 3 distinct elements is indices [5, 7] -> {3, 4, 5}
        assertArrayEquals(new int[]{5, 7}, Cold_Drink.drinks(arr, k));
    }

    @Test
    void testNoSolutionExists() {
        int[] arr = {1, 1, 2, 1, 2};
        int k = 3;
        // Returns {-1, -1} when no valid window of k distinct elements exists
        assertArrayEquals(new int[]{-1, -1}, Cold_Drink.drinks(arr, k));
    }

    @Test
    void testLexicographicalTie() {
        int[] arr = {1, 2, 3, 4, 1, 2, 3, 4};
        int k = 3;
        // Windows [0, 2] and [1, 3] both have length 3; picks [0, 2]
        assertArrayEquals(new int[]{0, 2}, Cold_Drink.drinks(arr, k));
    }

    @Test
    void testSingleElementKOne() {
        int[] arr = {4, 4, 4};
        int k = 1;
        assertArrayEquals(new int[]{0, 0}, Cold_Drink.drinks(arr, k));
    }

    @Test
    void testEntireArrayRequired() {
        int[] arr = {1, 2, 3, 4};
        int k = 4;
        assertArrayEquals(new int[]{0, 3}, Cold_Drink.drinks(arr, k));
    }
}
