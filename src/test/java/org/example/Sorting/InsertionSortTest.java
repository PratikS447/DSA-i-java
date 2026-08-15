package org.example.Sorting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class InsertionSortTest{

    @Test
    @DisplayName("Sorts an unsorted array")
    void testUnsortedArray(){
        int arr[] = {5, 2, 8, 1, 9, 3}; // arrange
        InsertionSort.instSort(arr); // act
        assertArrayEquals(new int[]{1, 2, 3, 5, 8, 9}, arr); // assert
    }

    @Test
    @DisplayName("Already sorted array stays sorted")
    void testAlreadySortedArray(){
        int arr[] = {1, 2, 3, 4, 5};
        InsertionSort.instSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    @DisplayName("Reverse sorted array gets sorted")
    void testReverseSortedArray(){
        int arr[] = {9, 7, 5, 3, 1};
        InsertionSort.instSort(arr);
        assertArrayEquals(new int[]{1, 3, 5, 7, 9}, arr);
    }

    @Test
    @DisplayName("Single element array remains unchanged")
    void testSingleElement(){
        int arr[] = {42};
        InsertionSort.instSort(arr);
        assertArrayEquals(new int[]{42}, arr);
    }

    @Test
    @DisplayName("Empty array does not throw")
    void testEmptyArray(){
        int arr[] = {};
        InsertionSort.instSort(arr); // loop condition i < 0 is false, no iterations
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    @DisplayName("Two element array gets sorted")
    void testTwoElements(){
        int arr[] = {2, 1};
        InsertionSort.instSort(arr);
        assertArrayEquals(new int[]{1, 2}, arr);
    }

    @Test
    @DisplayName("Array with duplicate values")
    void testDuplicates(){
        int arr[] = {4, 2, 4, 1, 2, 4};
        InsertionSort.instSort(arr);
        assertArrayEquals(new int[]{1, 2, 2, 4, 4, 4}, arr);
    }

    @Test
    @DisplayName("Array with negative numbers")
    void testNegativeNumbers(){
        int arr[] = {-5, 3, -1, 0, -8, 2};
        InsertionSort.instSort(arr);
        assertArrayEquals(new int[]{-8, -5, -1, 0, 2, 3}, arr);
    }

    @Test
    @DisplayName("Array with all same elements")
    void testAllSameElements(){
        int arr[] = {7, 7, 7, 7};
        InsertionSort.instSort(arr);
        assertArrayEquals(new int[]{7, 7, 7, 7}, arr);
    }

    @Test
    @DisplayName("Larger array to check overall correctness")
    void testLargerArray(){
        int arr[] = {12, 11, 13, 5, 6, 7, 100, -3, 45, 0};
        InsertionSort.instSort(arr);
        assertArrayEquals(new int[]{-3, 0, 5, 6, 7, 11, 12, 13, 45, 100}, arr);
    }
}