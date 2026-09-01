package org.example.HashMap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Array_Pair_Divisible_By_K_Test {

    private final Array_Pair_Divisible_By_K solution = new Array_Pair_Divisible_By_K();

    @Test
    @DisplayName("LeetCode canonical example - should be true")
    void classicLeetCodeExample() {
        // Arrange
        int[] arr = {1, 2, 3, 4, 5, 10, 6, 7, 8, 9};
        int k = 5;

        // Act
        boolean result = solution.canArrange(arr, k);

        // Assert
        assertTrue(result); // BUG: this currently returns false
    }

    @Test
    @DisplayName("Small classic example - should be true")
    void smallTruePairs() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int k = 7;
        assertTrue(solution.canArrange(arr, k));
    }

    @Test
    @DisplayName("Negative numbers with valid pairing - should be true")
    void negativeNumbers() {
        int[] arr = {-10, 10};
        int k = 2;
        assertTrue(solution.canArrange(arr, k));
    }

    @Test
    @DisplayName("Simple false case - remainder counts don't match")
    void simpleFalseCase() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int k = 10;
        assertFalse(solution.canArrange(arr, k));
    }

    @Test
    @DisplayName("All elements same remainder 0, even count - should be true")
    void allRemainderZeroEvenCount() {
        // Arrange: 10 elements, all divisible by k=3, arr.length/2 (5) >= k (3)
        int[] arr = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
        int k = 3;

        boolean result = solution.canArrange(arr, k);

        assertTrue(result); // BUG: loop runs r1 up to arr.length/2, hits r1=3 -> r2=0
                             // compares nonexistent remainder-3 bucket (0) against remainder-0 bucket (10) -> false negative
    }

    @Test
    @DisplayName("k even, r1 == k/2 with even count at that remainder - should be true")
    void midpointRemainderEvenCount() {
        int[] arr = {2, 6, 2, 6}; // all % 4 == 2, count = 4 (even)
        int k = 4;

        boolean result = solution.canArrange(arr, k);

        assertTrue(result); // BUG: r1==r2 branch returns false when count IS even (condition is inverted)
    }

    @Test
    @DisplayName("k even, r1 == k/2 with odd count at that remainder - should be false")
    void midpointRemainderOddCount() {
        int[] arr = {2, 6, 10}; // all % 4 == 2, count = 3 (odd), length too short to even reach r1=2 in the buggy loop
        int k = 4;

        boolean result = solution.canArrange(arr, k);

        assertFalse(result); // BUG: loop bound (arr.length/2 = 1) never reaches r1=2, so the odd-count check never runs -> wrongly returns true
    }

    @Test
    @DisplayName("Remainder 0 present with odd count - should be false")
    void remainderZeroOddCount() {
        int[] arr = {3, 3, 3};
        int k = 3;
        assertFalse(solution.canArrange(arr, k));
    }

    @Test
    @DisplayName("Larger array, k smaller than arr.length/2 - should be true")
    void kSmallerThanHalfLength() {
        // 8 elements, k=3, remainders balance out (2 ones, 2 twos, 4 zeros)
        int[] arr = {3, 6, 9, 12, 1, 4, 2, 5}; // %3: 0,0,0,0,1,1,2,2
        int k = 3;
        assertTrue(solution.canArrange(arr, k)); // also likely to break past r1=3 similarly to case above
    }
}