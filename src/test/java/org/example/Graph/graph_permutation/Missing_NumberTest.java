package org.example.Graph.graph_permutation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Missing_NumberTest {

    @Test
    @DisplayName("Middle number missing in unsorted array")
    void testMissingMiddleNumber() {
        int[] arr = {3, 0, 1};
        assertEquals(2, Missing_Number.missing_num(arr));
    }

    @Test
    @DisplayName("0 is the missing number")
    void testMissingZero() {
        int[] arr = {1, 2, 3};
        assertEquals(0, Missing_Number.missing_num(arr));
    }

    @Test
    @DisplayName("N (largest number) is the missing number")
    void testMissingN() {
        int[] arr = {0, 1, 2};
        assertEquals(3, Missing_Number.missing_num(arr));
    }

    @Test
    @DisplayName("Single element array missing 1")
    void testSingleElementMissingOne() {
        int[] arr = {0};
        assertEquals(1, Missing_Number.missing_num(arr));
    }

    @Test
    @DisplayName("Single element array missing 0")
    void testSingleElementMissingZero() {
        int[] arr = {1};
        assertEquals(0, Missing_Number.missing_num(arr));
    }

    @Test
    @DisplayName("Large unsorted array")
    void testLargeUnsortedArray() {
        int[] arr = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        assertEquals(8, Missing_Number.missing_num(arr));
    }

    @Test
    @DisplayName("Reverse sorted array missing number")
    void testReverseSortedArray() {
        int[] arr = {4, 3, 1, 0};
        assertEquals(2, Missing_Number.missing_num(arr));
    }

    @Test
    @DisplayName("Empty array should return 0")
    void testEmptyArray() {
        int[] arr = {};
        assertEquals(0, Missing_Number.missing_num(arr));
    }
}