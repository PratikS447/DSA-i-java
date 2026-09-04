package org.example.HashMap;

import org.example.TwoPointer_SlidingWindow.Number_Of_Valid_Triangle;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Number_Of_Valid_TriangleTest {

    @Test
    void testStandardCase() {
        // Classic LeetCode 611 example: [2,2,3,4] -> triangles: (2,3,4) and (2,3,4) [distinct 2's] = 3
        int[] arr = {2, 2, 3, 4};
        assertEquals(3, Number_Of_Valid_Triangle.triangle(arr));
    }

    @Test
    void testAllSameElements() {
        // Equal sides always form a valid triangle (equilateral)
        int[] arr = {4, 4, 4, 4};
        // C(4,3) = 4 combinations, all valid
        assertEquals(4, Number_Of_Valid_Triangle.triangle(arr));
    }

    @Test
    void testNoValidTriangles() {
        // Each element more than double the previous -> no valid triangle possible
        int[] arr = {1, 2, 4, 8};
        assertEquals(0, Number_Of_Valid_Triangle.triangle(arr));
    }

    @Test
    void testLessThanThreeElements() {
        int[] arr = {5, 10};
        assertEquals(0, Number_Of_Valid_Triangle.triangle(arr));
    }

    @Test
    void testEmptyArray() {
        int[] arr = {};
        assertEquals(0, Number_Of_Valid_Triangle.triangle(arr));
    }

    @Test
    void testSingleElement() {
        int[] arr = {7};
        assertEquals(0, Number_Of_Valid_Triangle.triangle(arr));
    }

    @Test
    void testUnsortedInputGetsSortedInternally() {
        // Same multiset as testStandardCase but shuffled input
        int[] arr = {4, 2, 3, 2};
        assertEquals(3, Number_Of_Valid_Triangle.triangle(arr));
    }

    @Test
    void testWithZeroValue() {
        // A zero side can never form a valid triangle with positive sides
        int[] arr = {0, 1, 2, 3};
        assertEquals(0, Number_Of_Valid_Triangle.triangle(arr));
    }

    @Test
    void testLargerMixedCase() {
        // [1,2,3,4,5,6] -> known count of valid triangles is 7
        int[] arr = {1, 2, 3, 4, 5, 6};
        assertEquals(7, Number_Of_Valid_Triangle.triangle(arr));
    }

    @Test
    void testDuplicatesFormingDegenerateTriangle() {
        // 1+1 = 2, not > 2, so this is degenerate, not valid
        int[] arr = {1, 1, 2};
        assertEquals(0, Number_Of_Valid_Triangle.triangle(arr));
    }

    @Test
    void testAllElementsFormValidTriangle() {
        // [3,4,5] classic right triangle: 3+4 > 5 -> valid
        int[] arr = {3, 4, 5};
        assertEquals(1, Number_Of_Valid_Triangle.triangle(arr));
    }

    @Test
    void testLargeIdenticalValues() {
        // Stress-ish check with more duplicates: C(5,3) = 10
        int[] arr = {10, 10, 10, 10, 10};
        assertEquals(10, Number_Of_Valid_Triangle.triangle(arr));
    }
}