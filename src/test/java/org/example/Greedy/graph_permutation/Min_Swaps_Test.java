package org.example.Greedy.graph_permutation;

import org.example.Graph.graph_permutation.Min_Swaps;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class Min_Swaps_Test {

    @Test
    @DisplayName("Already sorted array should remain unchanged")
    void testAlreadySorted() {
        // Arrange
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};

        // Act
        Min_Swaps.min_swaps_in_arr(arr, arr.length);

        // Assert
        assertArrayEquals(expected, arr, "Already sorted array should stay the same");
    }

    @Test
    @DisplayName("Fully reversed array should end up sorted")
    void testReversedArray() {
        // Arrange
        int[] arr = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};

        // Act
        Min_Swaps.min_swaps_in_arr(arr, arr.length);

        // Assert
        assertArrayEquals(expected, arr, "Reversed array should be sorted after cyclic sort");
    }

    @Test
    @DisplayName("Randomly shuffled array should end up sorted")
    void testShuffledArray() {
        // Arrange
        int[] arr = {3, 1, 5, 4, 2};
        int[] expected = {1, 2, 3, 4, 5};

        // Act
        Min_Swaps.min_swaps_in_arr(arr, arr.length);

        // Assert
        assertArrayEquals(expected, arr, "Shuffled array should be sorted after cyclic sort");
    }

    @Test
    @DisplayName("Single element array should remain unchanged")
    void testSingleElement() {
        // Arrange
        int[] arr = {1};
        int[] expected = {1};

        // Act
        Min_Swaps.min_swaps_in_arr(arr, arr.length);

        // Assert
        assertArrayEquals(expected, arr, "Single element array is trivially sorted");
    }

    @Test
    @DisplayName("Two elements swapped should be sorted after one swap")
    void testTwoElementsSwapped() {
        // Arrange
        int[] arr = {2, 1};
        int[] expected = {1, 2};

        // Act
        Min_Swaps.min_swaps_in_arr(arr, arr.length);

        // Assert
        assertArrayEquals(expected, arr, "Two swapped elements should be sorted with one swap");
    }

    @Test
    @DisplayName("Multiple disjoint cycles should all resolve correctly")
    void testMultipleDisjointCycles() {
        // Arrange
        // cycle 1: positions 0,3 (values 4,1)
        // cycle 2: positions 1,2 (values 3,2)
        int[] arr = {4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4};

        // Act
        Min_Swaps.min_swaps_in_arr(arr, arr.length);

        // Assert
        assertArrayEquals(expected, arr, "Array with multiple disjoint cycles should be fully sorted");
    }

    @Test
    @DisplayName("Larger array with mixed cycle sizes should end up sorted")
    void testLargerMixedArray() {
        // Arrange
        int[] arr = {6, 2, 4, 1, 5, 3};
        int[] expected = {1, 2, 3, 4, 5, 6};

        // Act
        Min_Swaps.min_swaps_in_arr(arr, arr.length);

        // Assert
        assertArrayEquals(expected, arr, "Larger array should be fully sorted regardless of cycle structure");
    }
}