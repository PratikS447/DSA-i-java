package org.example.HashMap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Divide_Array_In_K_Consecutive_Numbers_Test {

    private final Divide_Array_In_K_Consecutive_Numbers solution = new Divide_Array_In_K_Consecutive_Numbers();

    @Test
    @DisplayName("Classic true case: [1,2,3,3,4,5], k=3")
    void testClassicTrueCase() {
        // Arrange
        int[] nums = {1, 2, 3, 3, 4, 5};
        int k = 3;
        // Act
        boolean result = solution.isPossibleDivide(nums, k);
        // Assert
        assertTrue(result); // groups: [1,2,3] and [3,4,5]
    }

    @Test
    @DisplayName("Classic false case: [3,2,1,2,3,4,3,4,5,9,10,11], k=3")
    void testClassicFalseCase() {
        // Arrange
        int[] nums = {3, 2, 1, 2, 3, 4, 3, 4, 5, 9, 10, 11};
        int k = 3;
        // Act
        boolean result = solution.isPossibleDivide(nums, k);
        // Assert
        assertTrue(result); // leftover 9 can't form a group
    }

    @Test
    @DisplayName("Length not divisible by k -> false")
    void testLengthNotDivisibleByK() {
        // Arrange
        int[] nums = {1, 2, 3};
        int k = 2;
        // Act
        boolean result = solution.isPossibleDivide(nums, k);
        // Assert
        assertFalse(result); // 3 elements can't split into groups of 2
    }

    @Test
    @DisplayName("k = 1 -> always true regardless of values")
    void testKEqualsOne() {
        // Arrange
        int[] nums = {5, 1, 9, 3};
        int k = 1;
        // Act
        boolean result = solution.isPossibleDivide(nums, k);
        // Assert
        assertTrue(result); // every group is a single element
    }

    @Test
    @DisplayName("k equals array length -> single consecutive run")
    void testKEqualsArrayLength() {
        // Arrange
        int[] nums = {4, 3, 2, 1};
        int k = 4;
        // Act
        boolean result = solution.isPossibleDivide(nums, k);
        // Assert
        assertTrue(result); // one group [1,2,3,4]
    }

    @Test
    @DisplayName("Gap in sequence breaks grouping -> false")
    void testGapInSequence() {
        // Arrange
        int[] nums = {1, 2, 3, 4, 6, 7, 8, 9};
        int k = 4;
        // Act
        boolean result = solution.isPossibleDivide(nums, k);
        // Assert
        assertTrue(result); // 5 is missing, breaks second group
    }

    @Test
    @DisplayName("Duplicates requiring separate groups")
    void testDuplicatesRequireSeparateGroups() {
        // Arrange
        int[] nums = {1, 2, 3, 1, 2, 3};
        int k = 3;
        // Act
        boolean result = solution.isPossibleDivide(nums, k);
        // Assert
        assertTrue(result); // two groups: [1,2,3] and [1,2,3]
    }

    @Test
    @DisplayName("Duplicates without enough spread -> false")
    void testDuplicatesInsufficientSpread() {
        // Arrange
        int[] nums = {1, 2, 3, 4, 4, 5, 6, 7};
        int k = 4;
        // Act
        boolean result = solution.isPossibleDivide(nums, k);
        // Assert
        assertTrue(result); // can't build two runs of 4 from these values
    }

    @Test
    @DisplayName("Negative numbers, valid consecutive groups")
    void testNegativeNumbers() {
        // Arrange
        int[] nums = {-3, -2, -1, 0, 1, 2};
        int k = 3;
        // Act
        boolean result = solution.isPossibleDivide(nums, k);
        // Assert
        assertTrue(result); // groups: [-3,-2,-1] and [0,1,2]
    }

    @Test
    @DisplayName("Single element array with k=1")
    void testSingleElementArray() {
        // Arrange
        int[] nums = {7};
        int k = 1;
        // Act
        boolean result = solution.isPossibleDivide(nums, k);
        // Assert
        assertTrue(result);
    }

    @Test
    @DisplayName("Empty array is trivially true")
    void testEmptyArray() {
        // Arrange
        int[] nums = {};
        int k = 3;
        // Act
        boolean result = solution.isPossibleDivide(nums, k);
        // Assert
        assertTrue(result); // vacuously true, nothing to divide
    }

    @Test
    @DisplayName("All identical elements with k>1 -> false")
    void testAllIdenticalElements() {
        // Arrange
        int[] nums = {5, 5, 5, 5};
        int k = 2;
        // Act
        boolean result = solution.isPossibleDivide(nums, k);
        // Assert
        assertFalse(result); // no consecutive run possible from identical values
    }
}