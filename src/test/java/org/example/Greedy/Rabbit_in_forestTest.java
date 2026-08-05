package org.example.Greedy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Rabbit_in_forestTest {

    @Test
    void testStandardCase() {
        // [1, 1, 2] -> Two rabbits answer 1 (forms 1 group of 2), one answers 2 (forms 1 group of 3)
        // Total = 2 + 3 = 5
        int[] arr = {1, 1, 2};
        assertEquals(5, Rabbit_in_forest.in_forest(arr));
    }

    @Test
    void testMultipleGroupsSameAnswer() {
        // [10, 10, 10] -> Three rabbits answer 10 (group size = 11).
        // Since 3 <= 11, they can all be in the same group of 11.
        // Total = 11
        int[] arr = {10, 10, 10};
        assertEquals(11, Rabbit_in_forest.in_forest(arr));
    }

    @Test
    void testExceedingGroupCapacity() {
        // [0, 0, 1, 1, 1]
        // 0s: Two rabbits answer 0 (group size = 1) -> 2 separate groups of 1 = 2
        // 1s: Three rabbits answer 1 (group size = 2) -> ceil(3/2) = 2 groups of 2 = 4
        // Total = 2 + 4 = 6
        int[] arr = {0, 0, 1, 1, 1};
        assertEquals(6, Rabbit_in_forest.in_forest(arr));
    }

    @Test
    void testAllZeroes() {
        // Each rabbit says no other rabbit has their color, so each is in a group of 1
        int[] arr = {0, 0, 0};
        assertEquals(3, Rabbit_in_forest.in_forest(arr));
    }

    @Test
    void testEmptyArray() {
        // No rabbits in the forest
        int[] arr = {};
        assertEquals(0, Rabbit_in_forest.in_forest(arr));
    }

    @Test
    void testSingleElement() {
        // One rabbit answers 5 -> group size = 6
        int[] arr = {5};
        assertEquals(6, Rabbit_in_forest.in_forest(arr));
    }
}