package org.example.Stack_and_Queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;

public class Max_Sliding_Window_Test {
    private Max_Sliding_Window max_sliding_window;

    @BeforeEach
    void setUp(){
        max_sliding_window = new Max_Sliding_Window();
    }

    @Test
    public void testStandardCase(){
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] expected = {3, 3, 5, 5, 6, 7};
        assertArrayEquals(expected, max_sliding_window.max_slide(nums, k));
    }

    @Test
    public void test_Window_Size_One(){
        int nums[] = {4, 2, 5};
        int k = 1;
        int expected[] = {4, 2, 5};
        assertArrayEquals(expected, max_sliding_window.max_slide(nums, k));
    }

    @Test
    public void test_Window_Size_Equals_Array_Length(){
        int nums[] = {1, 3, -1, 2};
        int k = 4;
        int expected[] = {3};
        assertArrayEquals(expected, max_sliding_window.max_slide(nums, k));
    }

    @Test
    void testStrictlyIncreasing() {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 3;
        int[] expected = {3, 4, 5};
        assertArrayEquals(expected, max_sliding_window.max_slide(nums, k));
    }

    @Test
    void testStrictlyDecreasing() {
        int[] nums = {5, 4, 3, 2, 1};
        int k = 3;
        int[] expected = {5, 4, 3};
        assertArrayEquals(expected, max_sliding_window.max_slide(nums, k));
    }

    @Test
    void testAllNegativeNumbers() {
        int[] nums = {-7, -8, -2, -3};
        int k = 2;
        int[] expected = {-7, -2, -2};
        assertArrayEquals(expected, max_sliding_window.max_slide(nums, k));
    }

    @Test
    void testDuplicates() {
        int[] nums = {2, 2, 2, 2};
        int k = 2;
        int[] expected = {2, 2, 2};
        assertArrayEquals(expected, max_sliding_window.max_slide(nums, k));
    }

    @Test
    void testSingleElement() {
        int[] nums = {1};
        int k = 1;
        int[] expected = {1};
        assertArrayEquals(expected, max_sliding_window.max_slide(nums, k));
    }
}
