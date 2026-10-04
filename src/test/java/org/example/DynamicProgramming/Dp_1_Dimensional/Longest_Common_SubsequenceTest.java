package org.example.DynamicProgramming.Dp_1_Dimensional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Longest_Common_SubsequenceTest {

    private Longest_Common_Subsequence lcs;

    @BeforeEach
    void setUp() {
        // Fresh instance per test so no state can leak between tests
        lcs = new Longest_Common_Subsequence();
    }

    // ---------- Typical cases ----------

    @ParameterizedTest(name = "LCS(\"{0}\", \"{1}\") = {2}")
    @CsvSource({
            "abcde,   ace,      3",
            "abcdgh,  aedfhr,   3",
            "AGGTAB,  GXTXAYB,  4",
            "abcbdab, bdcaba,   4",
            "abc,     cba,      1",
            "aaaa,    aa,       2",
            "abc,     abc,      3",
            "abc,     def,      0",
            "a,       a,        1",
            "a,       b,        0"
    })

    @DisplayName("Known input/output pairs")
    void knownCases(String s1, String s2, int expected) {
        assertEquals(expected, lcs.memozation_method(s1.trim(), s2.trim()));
    }

    // ---------- Edge cases ----------

    @Test
    @DisplayName("Both strings empty -> 0")
    void bothEmpty() {
        assertEquals(0, lcs.memozation_method("", ""));
    }

    @Test
    @DisplayName("First string empty -> 0")
    void firstEmpty() {
        assertEquals(0, lcs.memozation_method("", "abc"));
    }

    @Test
    @DisplayName("Second string empty -> 0")
    void secondEmpty() {
        assertEquals(0, lcs.memozation_method("abc", ""));
    }

    @Test
    @DisplayName("One string is a subsequence of the other -> length of shorter")
    void subsequenceOfOther() {
        assertEquals(3, lcs.memozation_method("axbycz", "abc"));
        assertEquals(3, lcs.memozation_method("abc", "axbycz"));
    }

    @Test
    @DisplayName("Case-sensitive: 'a' != 'A'")
    void caseSensitive() {
        assertEquals(0, lcs.memozation_method("abc", "ABC"));
    }

    @Test
    @DisplayName("Handles non-letter characters and spaces")
    void specialCharacters() {
        assertEquals(3, lcs.memozation_method("a b-c", "a-b c"));
        assertEquals(2, lcs.memozation_method("1!2@", "!@"));
    }

    // ---------- Properties ----------

    @Test
    @DisplayName("LCS is symmetric: LCS(a, b) == LCS(b, a)")
    void symmetric() {
        String a = "AGGTAB";
        String b = "GXTXAYB";
        assertEquals(lcs.memozation_method(a, b), lcs.memozation_method(b, a));
    }

    @Test
    @DisplayName("LCS of a string with itself is its length")
    void identicalStrings() {
        String s = "dynamicprogramming";
        assertEquals(s.length(), lcs.memozation_method(s, s));
    }

    @Test
    @DisplayName("Result never exceeds the shorter string's length")
    void boundedByShorter() {
        String a = "abcdefghij";
        String b = "xaybzc";
        int result = lcs.memozation_method(a, b);
        assertTrue(result <= Math.min(a.length(), b.length()));
    }

    @Test
    @DisplayName("Same instance can be reused (memo is rebuilt on every call)")
    void reusableInstance() {
        assertEquals(3, lcs.memozation_method("abcde", "ace"));
        assertEquals(0, lcs.memozation_method("abc", "def"));
        assertEquals(3, lcs.memozation_method("abcde", "ace"));
    }

    // ---------- Larger input ----------

    @Test
    @DisplayName("Moderately large identical strings finish quickly and correctly")
    void largeInput() {
        // Memoization keeps this O(n*m). Without it, this would never finish.
        // Kept at 500 so recursion depth (~n+m frames) stays safe for the default stack.
        String s = "ab".repeat(250); // length 500
        assertEquals(500, lcs.memozation_method(s, s));
    }
}