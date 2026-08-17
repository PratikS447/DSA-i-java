package org.example.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Divide_Array_K_Consecutive_NumberTest {

    private Divide_Array_K_Consecutive_Number solution;

    @BeforeEach
    void setUp() {
        solution = new Divide_Array_K_Consecutive_Number();
    }

    @Test
    @DisplayName("Valid division with standard sorted inputs")
    void testStandardValidDivision() {
        int[] nums = {1, 2, 3, 3, 4, 5, 6, 7, 8};
        int k = 3;
        assertTrue(solution.isPossibleDivide(nums, k)); // [1,2,3], [3,4,5], [6,7,8]
    }

    @Test
    @DisplayName("Valid division with unsorted inputs and duplicate values")
    void testUnsortedValidDivision() {
        int[] nums = {3, 2, 1, 2, 3, 4};
        int k = 3;
        assertTrue(solution.isPossibleDivide(nums, k)); // [1,2,3], [2,3,4]
    }

    @Test
    @DisplayName("Invalid: Array length is not divisible by k")
    void testLengthNotDivisibleByK() {
        int[] nums = {1, 2, 3, 4};
        int k = 3;
        assertFalse(solution.isPossibleDivide(nums, k));
    }

    @Test
    @DisplayName("Invalid: Missing consecutive numbers in sequence")
    void testMissingConsecutiveNumbers() {
        int[] nums = {1, 2, 4, 5, 6, 7};
        int k = 3;
        assertFalse(solution.isPossibleDivide(nums, k)); // [1,2,?] fails because 3 is missing
    }

    @Test
    @DisplayName("Invalid: Duplicate counts don't match group requirements")
    void testInsufficientDuplicates() {
        int[] nums = {1, 2, 3, 2, 3, 5};
        int k = 3;
        assertFalse(solution.isPossibleDivide(nums, k)); // [1,2,3] leaves [2,3,5], which cannot form [2,3,4]
    }

    @Test
    @DisplayName("Edge Case: k = 1 should always return true")
    void testKEqualsOne() {
        int[] nums = {5, 10, 100, 2};
        int k = 1;
        assertTrue(solution.isPossibleDivide(nums, k));
    }

    @Test
    @DisplayName("Edge Case: Negative numbers in array")
    void testNegativeNumbers() {
        int[] nums = {-3, -2, -1, 0, 1, 2};
        int k = 3;
        assertTrue(solution.isPossibleDivide(nums, k)); // [-3,-2,-1], [0,1,2]
    }

    @Test
    @DisplayName("Edge Case: Single group where nums.length == k")
    void testSingleGroup() {
        int[] nums = {10, 11, 12};
        int k = 3;
        assertTrue(solution.isPossibleDivide(nums, k));
    }
}