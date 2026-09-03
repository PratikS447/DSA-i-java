package org.example.Backtracking_and_recusion.Backtracking;

import org.example.Backtracking_and_recusion.backtracking.Combination;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CombinationTest {

    @Test
    @DisplayName("n=4, k=2 should produce all 2-element combinations of 1..4")
    void testStandardCase() {
        // Arrange
        int n = 4, k = 2;

        // Act
        List<List<Integer>> result = Combination.nCr(n, k);

        // Assert
        List<List<Integer>> expected = List.of(
                List.of(1, 2),
                List.of(1, 3),
                List.of(1, 4),
                List.of(2, 3),
                List.of(2, 4),
                List.of(3, 4)
        );
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("k=0 should return a single empty combination")
    void testKIsZero() {
        // Arrange
        int n = 5, k = 0;

        // Act
        List<List<Integer>> result = Combination.nCr(n, k);

        // Assert
        assertEquals(1, result.size());
        assertTrue(result.get(0).isEmpty());
    }

    @Test
    @DisplayName("k equals n should return exactly one combination containing all elements")
    void testKEqualsN() {
        // Arrange
        int n = 3, k = 3;

        // Act
        List<List<Integer>> result = Combination.nCr(n, k);

        // Assert
        assertEquals(1, result.size());
        assertEquals(List.of(1, 2, 3), result.get(0));
    }

    @Test
    @DisplayName("k greater than n should return no combinations")
    void testKGreaterThanN() {
        // Arrange
        int n = 3, k = 5;

        // Act
        List<List<Integer>> result = Combination.nCr(n, k);

        // Assert
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("n=1, k=1 should return a single combination with element 1")
    void testSingleElement() {
        // Arrange
        int n = 1, k = 1;

        // Act
        List<List<Integer>> result = Combination.nCr(n, k);

        // Assert
        assertEquals(1, result.size());
        assertEquals(List.of(1), result.get(0));
    }

    @Test
    @DisplayName("Every combination returned should have exactly k elements")
    void testAllCombinationsHaveCorrectSize() {
        // Arrange
        int n = 6, k = 3;

        // Act
        List<List<Integer>> result = Combination.nCr(n, k);

        // Assert
        for (List<Integer> combo : result) {
            assertEquals(k, combo.size());
        }
    }

    @Test
    @DisplayName("Total number of combinations should match nCr formula (n=5, k=2 => 10)")
    void testCombinationCount() {
        // Arrange
        int n = 5, k = 2;

        // Act
        List<List<Integer>> result = Combination.nCr(n, k);

        // Assert
        assertEquals(10, result.size()); // 5C2 = 10
    }
}