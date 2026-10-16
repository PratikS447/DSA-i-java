package org.example.DynamicProgramming.DP_On_Subsequence;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Longest_Subsequence_With_Adj_Diff_1_Test {

    private int solve(int... arr) {
        return Longest_Subsequence_With_Adj_Diff_1.subequenct_with_diff_1(arr);
    }

    // ---------- CSV-driven tests ----------
    // Needs src/test/resources/Longest_Subsequence_With_Adj_Diff_1_tests.csv
    // and the junit-jupiter-params dependency.
//    @ParameterizedTest(name = "{0}")
//    @CsvFileSource(resources = "/DynamicProgramming/DP_On_Subsequence/Longest_Subsequence_With_Adj_Diff_1_tests.csv", numLinesToSkip = 1)
//    void fromCsv(String name, String input, int expected) {
//        int[] arr = (input == null || input.isBlank())
//                ? new int[0]
//                : Arrays.stream(input.trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
//        assertEquals(expected, solve(arr));
//    }

    // ---------- Hand-written tests ----------
    @Test
    void emptyArray() {
        assertEquals(0, solve());
    }

    @Test
    void singleElement() {
        assertEquals(1, solve(7));
    }

    @Test
    void allEqualElements() {
        // diff is 0, never 1, so best is any single element
        assertEquals(1, solve(5, 5, 5, 5));
    }

    @Test
    void strictlyIncreasingByOne() {
        assertEquals(5, solve(1, 2, 3, 4, 5));
    }

    @Test
    void strictlyDecreasingByOne() {
        assertEquals(5, solve(5, 4, 3, 2, 1));
    }

    @Test
    void zigzag() {
        assertEquals(6, solve(1, 2, 1, 2, 1, 2));
    }

    @Test
    void mountainShape() {
        assertEquals(5, solve(1, 2, 3, 2, 1));
    }

    @Test
    void noValidPair() {
        assertEquals(1, solve(1, 3, 5, 7));
    }

    @Test
    void mixedWithGaps() {
        assertEquals(3, solve(10, 9, 4, 5, 4, 8, 6));
    }

    @Test
    void mustSkipNoiseInBetween() {
        // 1,2,3 picked around the 5 and 6
        assertEquals(3, solve(1, 5, 2, 6, 3));
    }

    @Test
    void duplicatesMustBeSkipped() {
        // 3,2,1 (skip the second 2)
        assertEquals(3, solve(3, 2, 2, 1));
    }

    @Test
    void negativeNumbers() {
        assertEquals(5, solve(-1, 0, 1, 0, -1));
    }

    @Test
    void differenceOfTwoIsNotAllowed() {
        assertEquals(1, solve(2, 4, 6, 8));
    }

    // ---------- Randomized cross-check against brute force ----------
    @Test
    void matchesBruteForceOnRandomInputs() {
        Random rnd = new Random(42);
        for (int t = 0; t < 200; t++) {
            int n = rnd.nextInt(12) + 1;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = rnd.nextInt(7) - 3; // small range => many valid pairs
            assertEquals(brute(arr), solve(arr), "Failed for input: " + Arrays.toString(arr));
        }
    }

    // Checks every subsequence via bitmask
    private int brute(int[] arr) {
        int n = arr.length, best = 0;
        for (int mask = 1; mask < (1 << n); mask++) {
            int prev = Integer.MIN_VALUE, len = 0;
            boolean ok = true;
            for (int i = 0; i < n && ok; i++) {
                if ((mask & (1 << i)) == 0) continue;
                if (len > 0 && Math.abs(arr[i] - prev) != 1) ok = false;
                prev = arr[i];
                len++;
            }
            if (ok) best = Math.max(best, len);
        }
        return best;
    }
}