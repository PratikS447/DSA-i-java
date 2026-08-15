package org.example.Sorting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SelectionSortTest {

    @Test
    @DisplayName("Sorts an unsorted array")
    void testUnsortedArray(){
        int arr[] = {5, 2, 8, 1, 9, 3};
        SelectionSort.selSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 5, 8, 9}, arr);
    }

    @Test
    @DisplayName("Reverse sorted array gets sorted")
    void testReverseSortedArray(){
        int arr[] = {9, 7, 5, 3, 1};
        SelectionSort.selSort(arr);
        assertArrayEquals(new int[]{1, 3, 5, 7, 9}, arr);
    }

    @Test
    @DisplayName("Empty array does not throw")
    void testEmptyArray(){
        int arr[] = {};
        SelectionSort.selSort(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    @DisplayName("Single element array remains unchanged")
    void testSingleElement(){
        int arr[] = {42};
        SelectionSort.selSort(arr);
        assertArrayEquals(new int[]{42}, arr);
    }

    @Test
    @DisplayName("Array with duplicate values")
    void testDuplicates(){
        int arr[] = {4, 2, 4, 1, 2, 4};
        SelectionSort.selSort(arr);
        assertArrayEquals(new int[]{1, 2, 2, 4, 4, 4}, arr);
    }

    @Test
    @DisplayName("Array with negative numbers")
    void testNegativeNumbers(){
        int arr[] = {-5, 3, -1, 0, -8, 2};
        SelectionSort.selSort(arr);
        assertArrayEquals(new int[]{-8, -5, -1, 0, 2, 3}, arr);
    }

    // --- Algorithm-specific tests below: verify selection-sort's exact mechanics ---

    @Test
    @DisplayName("Selects minimum from unsorted suffix each pass (partial-sort snapshot)")
    void testMinimumSelectionPerPass(){
        // After i=0, position 0 must hold the global minimum.
        // After i=1, position 1 must hold the minimum of the remaining suffix.
        // This is specific to selection sort's "find min, place at front" strategy —
        // e.g. bubble sort would not necessarily place the correct element this early
        // in an identical intermediate state.
        int arr[] = {5, 3, 8, 1, 9, 2};
        int expectedAfterFullSort[] = {1, 2, 3, 5, 8, 9};

        SelectionSort.selSort(arr);

        assertEquals(expectedAfterFullSort[0], arr[0]);
        assertEquals(expectedAfterFullSort[1], arr[1]);
    }

    @Test
    @DisplayName("Every outer iteration performs a swap, even a no-op self-swap (arr[minIdx]==arr[i])")
    void testUnconditionalSwapEvenWhenMinIsCurrentIndex(){
        // arr[0]=1 is already the min, so minIdx will equal i=0.
        // This implementation has no 'if (minIdx != i)' guard, so it still executes
        // the swap statements (a self-swap). Result must still be correct —
        // this distinguishes it from an "optimized" selection sort that skips no-op swaps,
        // though both produce the same final array.
        int arr[] = {1, 5, 4, 3, 2};
        SelectionSort.selSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    @DisplayName("Strictly greater-than comparison means stable-ish behavior for adjacent equal min candidates")
    void testStrictGreaterThanComparisonOnTiedMinima(){
        // arr[minIdx] > arr[j] is strict, so when multiple equal minimums exist,
        // minIdx stays at the FIRST occurrence found (not overwritten by a later tie).
        // This confirms the exact comparison operator used, not just final sortedness.
        int arr[] = {3, 1, 1, 2};
        SelectionSort.selSort(arr);
        assertArrayEquals(new int[]{1, 1, 2, 3}, arr);
    }

    @Test
    @DisplayName("Array with all same elements — every pass finds minIdx == i")
    void testAllSameElements(){
        int arr[] = {7, 7, 7, 7};
        SelectionSort.selSort(arr);
        assertArrayEquals(new int[]{7, 7, 7, 7}, arr);
    }

    @Test
    @DisplayName("Larger array to check overall correctness")
    void testLargerArray(){
        int arr[] = {12, 11, 13, 5, 6, 7, 100, -3, 45, 0};
        SelectionSort.selSort(arr);
        assertArrayEquals(new int[]{-3, 0, 5, 6, 7, 11, 12, 13, 45, 100}, arr);
    }
}