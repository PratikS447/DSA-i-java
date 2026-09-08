package org.example.Backtracking_and_recusion.Backtracking;

import org.example.Backtracking_and_recusion.backtracking.ArrayPermuation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayPermuationTest {

    @Test
    @DisplayName("Permutations of [1,2,3] should return all 6 orderings")
    void testThreeElementArray() {
        // Arrange
        List<List<Integer>> ans = new ArrayList<>();
        int[] arr = {1, 2, 3};

        // Act
        ArrayPermuation.print(new ArrayList<>(), ans, arr);

        // Assert
        assertEquals(6, ans.size());
        List<List<Integer>> expected = List.of(
                List.of(1, 2, 3),
                List.of(1, 3, 2),
                List.of(2, 1, 3),
                List.of(2, 3, 1),
                List.of(3, 1, 2),
                List.of(3, 2, 1)
        );
        assertTrue(ans.containsAll(expected));
        assertTrue(expected.containsAll(ans));
    }

    @Test
    @DisplayName("Single element array should return exactly one permutation")
    void testSingleElementArray() {
        // Arrange
        List<List<Integer>> ans = new ArrayList<>();
        int[] arr = {5};

        // Act
        ArrayPermuation.print(new ArrayList<>(), ans, arr);

        // Assert
        assertEquals(1, ans.size());
        assertEquals(List.of(5), ans.get(0));
    }

    @Test
    @DisplayName("Empty array should return one empty permutation")
    void testEmptyArray() {
        // Arrange
        List<List<Integer>> ans = new ArrayList<>();
        int[] arr = {};

        // Act
        ArrayPermuation.print(new ArrayList<>(), ans, arr);

        // Assert
        assertEquals(1, ans.size());
        assertTrue(ans.get(0).isEmpty());
    }

    @Test
    @DisplayName("Two element array should return exactly 2 permutations")
    void testTwoElementArray() {
        // Arrange
        List<List<Integer>> ans = new ArrayList<>();
        int[] arr = {7, 9};

        // Act
        ArrayPermuation.print(new ArrayList<>(), ans, arr);

        // Assert
        assertEquals(2, ans.size());
        assertTrue(ans.contains(List.of(7, 9)));
        assertTrue(ans.contains(List.of(9, 7)));
    }

    @Test
    @DisplayName("Duplicate values produce fewer permutations than n! due to contains() check")
    void testDuplicateValues() {
        // Arrange
        List<List<Integer>> ans = new ArrayList<>();
        int[] arr = {1, 1, 2};

        // Act
        ArrayPermuation.print(new ArrayList<>(), ans, arr);

        // Assert
        // NOTE: curr.contains(arr[i]) treats both 1's as identical values,
        // so the recursion under-generates compared to true 3! = 6 permutations
        // of *positions*. This test documents the current behavior — it's a
        // sign this function isn't safe for arrays with duplicate elements.
        assertTrue(ans.size() < 6, "Expected fewer than 6 permutations due to duplicate-skipping via contains()");
    }
}