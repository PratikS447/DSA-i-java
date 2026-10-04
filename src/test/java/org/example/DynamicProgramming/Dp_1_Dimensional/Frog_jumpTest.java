package org.example.DynamicProgramming.Dp_1_Dimensional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import java.util.Arrays;


import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Runs the same cases against both Frog_jump implementations (memoization + tabulation).
 * Inputs follow the LeetCode 403 contract: at least 2 stones, sorted, strictly increasing, first stone at 0.
 */
class Frog_jumpTest {

    // ---------- Providers ----------
    @ParameterizedTest(name = "{2}: [{0}] -> {1}")
    @CsvFileSource(resources = "/DynamicProgramming/Dp_1_Dimensional/frog_cases.csv")
    @DisplayName("Known cases loaded from frog_cases.csv")
    void knownCasesFromCsv(String stonesText, boolean expected, String description) {
        int[] stones = Arrays.stream(stonesText.trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        assertEquals(expected, new Frog_jump().memoization(stones));
        assertEquals(expected, new Frog_jump().tabulation(stones));
    }
}