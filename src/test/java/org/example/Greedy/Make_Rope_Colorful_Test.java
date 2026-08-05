package org.example.Greedy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Make_Rope_Colorful_Test {
    private final Make_Rope_Colorful solution = new Make_Rope_Colorful();

    @Test
    @DisplayName("Standard case with one duplicate group in the middle")
    void testStandardCase() {
        // Arrange
        String colors = "abaac";
        int[] neededTime = {1, 2, 3, 4, 5};

        // Act
        int result = solution.min_cost(colors, neededTime);

        // Assert
        assertEquals(3, result, "Should remove cheaper box (cost 3) from the 'aa' pair, keeping cost 4");
    }

    @Test
    @DisplayName("Already colorful string should return 0")
    void testAlreadyColorful() {
        // Arrange
        String colors = "abac";
        int[] neededTime = {3, 2, 4, 1};

        // Act
        int result = solution.min_cost(colors, neededTime);

        // Assert
        assertEquals(0, result, "No consecutive duplicates, so no removal needed");
    }

    @Test
    @DisplayName("Duplicate group NOT at the start of the string (control case)")
    void testDuplicateGroupInMiddle() {
        // Arrange
        String colors = "bcaaa";
        int[] neededTime = {9, 9, 1, 2, 3};

        // Act
        int result = solution.min_cost(colors, neededTime);

        // Assert
        assertEquals(3, result, "Group 'aaa' (costs 1,2,3): sum=6, keep max=3, remove cost = 6-3 = 3");
    }

    @Test
    @DisplayName("Duplicate group starting at index 0 (edge case)")
    void testDuplicateGroupAtStart() {
        // Arrange
        String colors = "aaa";
        int[] neededTime = {1, 2, 3};

        // Act
        int result = solution.min_cost(colors, neededTime);

        // Assert
        assertEquals(3, result, "Group 'aaa' (costs 1,2,3): sum=6, keep max=3, remove cost = 6-3 = 3");
    }

    @Test
    @DisplayName("Two separate duplicate groups, first one starting at index 0")
    void testTwoGroupsFirstAtStart() {
        // Arrange
        String colors = "aabaa";
        int[] neededTime = {1, 2, 3, 4, 5};

        // Act
        int result = solution.min_cost(colors, neededTime);

        // Assert
        // Group 1 "aa" (indices 0,1): costs [1,2], sum=3, keep max=2, remove cost=1
        // Group 2 "aa" (indices 3,4): costs [4,5], sum=9, keep max=5, remove cost=4
        assertEquals(5, result, "Total should be 1 (first group) + 4 (second group) = 5");
    }

    @Test
    @DisplayName("Single character string should return 0")
    void testSingleCharacter() {
        // Arrange
        String colors = "a";
        int[] neededTime = {5};

        // Act
        int result = solution.min_cost(colors, neededTime);

        // Assert
        assertEquals(0, result, "A single box can't have a duplicate neighbor, so no removal needed");
    }

    @Test
    @DisplayName("All same color, long run")
    void testAllSameColor() {
        // Arrange
        String colors = "aaaaa";
        int[] neededTime = {1, 2, 3, 4, 5};

        // Act
        int result = solution.min_cost(colors, neededTime);

        // Assert
        // sum = 15, keep max = 5, remove cost = 15 - 5 = 10
        assertEquals(10, result, "Entire string is one group: sum=15, keep max=5, remove cost=10");
    }
}
