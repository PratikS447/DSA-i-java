package org.example.Graph.graph_permutation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Roll_NumberTest {

    @Test
    @DisplayName("Standard case: Missing number is in the middle")
    void testStandardCase() {
        int[] nums = {3, 1, 2, 5, 3};
        // Duplicate: 3, Missing: 4
        int[] expected = {3, 4};
        assertArrayEquals(expected, Roll_Number.find_repeating_and_missing_number(nums));
    }

    @Test
    @DisplayName("Boundary case: Missing number is at the end")
    void testMissingAtEnd() {
        int[] nums = {1, 1, 3};
        // Duplicate: 1, Missing: 2
        int[] expected = {1, 2};
        assertArrayEquals(expected, Roll_Number.find_repeating_and_missing_number(nums));
    }

    @Test
    @DisplayName("Boundary case: Missing number is at the start")
    void testMissingAtStart() {
        int[] nums = {2, 2, 3};
        // Duplicate: 2, Missing: 1
        int[] expected = {2, 1};
        assertArrayEquals(expected, Roll_Number.find_repeating_and_missing_number(nums));
    }

    @Test
    @DisplayName("Minimal input size: N = 2")
    void testMinimalArraySize() {
        int[] nums = {2, 2};
        // Duplicate: 2, Missing: 1
        int[] expected = {2, 1};
        assertArrayEquals(expected, Roll_Number.find_repeating_and_missing_number(nums));
    }

    @Test
    @DisplayName("Unsorted large array with duplicate far from missing")
    void testUnsortedLargeArray() {
        int[] nums = {4, 3, 6, 2, 1, 1};
        // Duplicate: 1, Missing: 5
        int[] expected = {1, 5};
        assertArrayEquals(expected, Roll_Number.find_repeating_and_missing_number(nums));
    }

    @Test
    @DisplayName("Array already mostly ordered")
    void testMostlyOrderedArray() {
        int[] nums = {1, 2, 2, 4};
        // Duplicate: 2, Missing: 3
        int[] expected = {2, 3};
        assertArrayEquals(expected, Roll_Number.find_repeating_and_missing_number(nums));
    }
}