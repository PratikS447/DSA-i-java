package org.example.Array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Array_AddingTest {

    @Test
    void addsArraysOfEqualLengthWithoutCarry() {
        // 123 + 456 = 579
        assertArrayEquals(new int[]{5, 7, 9},
                Array_Adding.arrayAdding(new int[]{1, 2, 3}, new int[]{4, 5, 6}));
    }

    @Test
    void addsArraysOfEqualLengthWithCarryInMiddle() {
        // 189 + 211 = 400
        assertArrayEquals(new int[]{4, 0, 0},
                Array_Adding.arrayAdding(new int[]{1, 8, 9}, new int[]{2, 1, 1}));
    }

    @Test
    void finalCarryIncreasesResultLength() {
        // 999 + 1 = 1000
        assertArrayEquals(new int[]{1, 0, 0, 0},
                Array_Adding.arrayAdding(new int[]{9, 9, 9}, new int[]{1}));
    }

    @Test
    void firstArrayLongerThanSecond() {
        // 1234 + 56 = 1290
        assertArrayEquals(new int[]{1, 2, 9, 0},
                Array_Adding.arrayAdding(new int[]{1, 2, 3, 4}, new int[]{5, 6}));
    }

    @Test
    void secondArrayLongerThanFirst() {
        // 56 + 1234 = 1290
        assertArrayEquals(new int[]{1, 2, 9, 0},
                Array_Adding.arrayAdding(new int[]{5, 6}, new int[]{1, 2, 3, 4}));
    }

    @Test
    void carryPropagatesThroughAllDigits() {
        // 99 + 99 = 198
        assertArrayEquals(new int[]{1, 9, 8},
                Array_Adding.arrayAdding(new int[]{9, 9}, new int[]{9, 9}));
    }

    @Test
    void addsSingleDigitsWithoutCarry() {
        assertArrayEquals(new int[]{7},
                Array_Adding.arrayAdding(new int[]{3}, new int[]{4}));
    }

    @Test
    void addsSingleDigitsWithCarry() {
        // 9 + 9 = 18
        assertArrayEquals(new int[]{1, 8},
                Array_Adding.arrayAdding(new int[]{9}, new int[]{9}));
    }

    @Test
    void addingZeroReturnsSameNumber() {
        assertArrayEquals(new int[]{1, 2, 3},
                Array_Adding.arrayAdding(new int[]{1, 2, 3}, new int[]{0}));
    }

    @Test
    void addingZeroToZero() {
        assertArrayEquals(new int[]{0},
                Array_Adding.arrayAdding(new int[]{0}, new int[]{0}));
    }

    @Test
    void doesNotModifyInputArrays() {
        int[] a = {9, 9};
        int[] b = {1};
        Array_Adding.arrayAdding(a, b);
        assertArrayEquals(new int[]{9, 9}, a);
        assertArrayEquals(new int[]{1}, b);
    }
}