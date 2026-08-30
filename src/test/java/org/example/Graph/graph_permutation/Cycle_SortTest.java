package org.example.Graph.graph_permutation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class Cycle_SortTest {

    @Test
    public void testAlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        Cycle_Sort.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testReverseSorted() {
        int[] arr = {5, 4, 3, 2, 1};
        Cycle_Sort.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testRandomOrder() {
        int[] arr = {3, 1, 2};
        Cycle_Sort.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3}, arr);
    }

    @Test
    public void testAnotherRandomOrder() {
        int[] arr = {4, 2, 5, 1, 3};
        Cycle_Sort.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testSingleElement() {
        int[] arr = {1};
        Cycle_Sort.sort(arr);
        assertArrayEquals(new int[]{1}, arr);
    }

    @Test
    public void testTwoElementsSorted() {
        int[] arr = {1, 2};
        Cycle_Sort.sort(arr);
        assertArrayEquals(new int[]{1, 2}, arr);
    }

    @Test
    public void testTwoElementsUnsorted() {
        int[] arr = {2, 1};
        Cycle_Sort.sort(arr);
        assertArrayEquals(new int[]{1, 2}, arr);
    }

    @Test
    public void testLargerPermutation() {
        int[] arr = {8, 3, 5, 1, 7, 2, 6, 4};
        Cycle_Sort.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, arr);
    }

    @Test
    public void testEmptyArray() {
        int[] arr = {};
        Cycle_Sort.sort(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    public void testWorstCaseSwapChain() {
        // Every element in a single long cycle: 2->3->4->5->1
        int[] arr = {2, 3, 4, 5, 1};
        Cycle_Sort.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testMultipleIndependentCycles() {
        // (1 2)(3 4) style cycles: swaps 1<->2 and 3<->4, 5 fixed
        int[] arr = {2, 1, 4, 3, 5};
        Cycle_Sort.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testLargeRandomPermutation() {
        int n = 1000;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = i + 1;
        // shuffle
        java.util.Collections.shuffle(Arrays.asList(java.util.stream.IntStream
                .of(arr).boxed().toArray(Integer[]::new)));
        // simpler shuffle approach:
        java.util.Random rand = new java.util.Random(42);
        for (int i = n - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
        }

        int[] expected = new int[n];
        for (int i = 0; i < n; i++) expected[i] = i + 1;

        Cycle_Sort.sort(arr);
        assertArrayEquals(expected, arr);
    }
}