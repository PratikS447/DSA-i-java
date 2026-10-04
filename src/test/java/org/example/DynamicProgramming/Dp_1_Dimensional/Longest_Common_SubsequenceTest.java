package org.example.DynamicProgramming.Dp_1_Dimensional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.function.BiFunction;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests both LCS implementations (memoization + tabulation) with the same cases,
 * so any behavioural difference between the two shows up immediately.
 */
class Longest_Common_SubsequenceTest {

    private static final String MEMO = "memoization";
    private static final String TABULATION = "tabulation";

    // ---------- Providers ----------

    /** The two implementations under test. A new instance per call keeps tests independent. */
    static Stream<Named<BiFunction<String, String, Integer>>> implementations() {
        return Stream.of(
                Named.of(MEMO, (a, b) -> new Longest_Common_Subsequence().memozation_method(a, b)),
                Named.of(TABULATION, (a, b) -> new Longest_Common_Subsequence().lcs(a, b))
        );
    }

    /** Cross product: every (s1, s2, expected) case is run against every implementation. */
    static Stream<Arguments> knownCases() {
        Object[][] data = {
                {"abcde", "ace", 3},
                {"abcdgh", "aedfhr", 3},
                {"AGGTAB", "GXTXAYB", 4},
                {"abcbdab", "bdcaba", 4},
                {"abc", "cba", 1},
                {"aaaa", "aa", 2},
                {"abc", "abc", 3},
                {"abc", "def", 0},
                {"a", "a", 1},
                {"a", "b", 0},
                {"axbycz", "abc", 3},      // second is a subsequence of first
                {"abc", "axbycz", 3},      // first is a subsequence of second
                {"abc", "ABC", 0},         // case-sensitive
                {"1!2@", "!@", 2},         // non-letter characters
                {"a b-c", "a-b c", 3}      // spaces and punctuation
        };
        return implementations().flatMap(impl ->
                Stream.of(data).map(row -> Arguments.of(impl, row[0], row[1], row[2])));
    }

    // ---------- Known input/output pairs ----------

    @ParameterizedTest(name = "[{0}] LCS(\"{1}\", \"{2}\") = {3}")
    @MethodSource("knownCases")
    @DisplayName("Known input/output pairs")
    void knownCases(BiFunction<String, String, Integer> lcs, String s1, String s2, int expected) {
        assertEquals(expected, lcs.apply(s1, s2));
    }

    // ---------- Edge cases ----------

    @ParameterizedTest(name = "[{0}]")
    @MethodSource("implementations")
    @DisplayName("Both strings empty -> 0")
    void bothEmpty(BiFunction<String, String, Integer> lcs) {
        assertEquals(0, lcs.apply("", ""));
    }

    @ParameterizedTest(name = "[{0}]")
    @MethodSource("implementations")
    @DisplayName("One string empty -> 0 (either side)")
    void oneEmpty(BiFunction<String, String, Integer> lcs) {
        assertEquals(0, lcs.apply("", "abc"));
        assertEquals(0, lcs.apply("abc", ""));
    }

    // ---------- Properties ----------

    @ParameterizedTest(name = "[{0}]")
    @MethodSource("implementations")
    @DisplayName("Symmetric: LCS(a, b) == LCS(b, a)")
    void symmetric(BiFunction<String, String, Integer> lcs) {
        String a = "AGGTAB";
        String b = "GXTXAYB";
        assertEquals(lcs.apply(a, b), lcs.apply(b, a));
    }

    @ParameterizedTest(name = "[{0}]")
    @MethodSource("implementations")
    @DisplayName("LCS of a string with itself is its length")
    void identicalStrings(BiFunction<String, String, Integer> lcs) {
        String s = "dynamicprogramming";
        assertEquals(s.length(), lcs.apply(s, s));
    }

    @ParameterizedTest(name = "[{0}]")
    @MethodSource("implementations")
    @DisplayName("Result never exceeds the shorter string's length")
    void boundedByShorter(BiFunction<String, String, Integer> lcs) {
        String a = "abcdefghij";
        String b = "xaybzc";
        assertTrue(lcs.apply(a, b) <= Math.min(a.length(), b.length()));
    }

    // ---------- Instance reuse ----------

    @Test
    @DisplayName("Same instance can be reused across calls (both methods)")
    void reusableInstance() {
        Longest_Common_Subsequence obj = new Longest_Common_Subsequence();
        assertEquals(3, obj.memozation_method("abcde", "ace"));
        assertEquals(0, obj.memozation_method("abc", "def"));
        assertEquals(3, obj.lcs("abcde", "ace"));
        assertEquals(0, obj.lcs("abc", "def"));
        assertEquals(3, obj.memozation_method("abcde", "ace"));
    }

    // ---------- Cross-check ----------

    @Test
    @DisplayName("Memoization and tabulation agree on random strings")
    void implementationsAgreeOnRandomInput() {
        Longest_Common_Subsequence obj = new Longest_Common_Subsequence();
        Random random = new Random(42); // fixed seed -> reproducible failures
        for (int i = 0; i < 300; i++) {
            String a = randomString(random, random.nextInt(31));
            String b = randomString(random, random.nextInt(31));
            assertEquals(obj.lcs(a, b), obj.memozation_method(a, b),
                    "Mismatch for \"" + a + "\" and \"" + b + "\"");
        }
    }

    private static String randomString(Random random, int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append((char) ('a' + random.nextInt(3))); // small alphabet -> many matches
        }
        return sb.toString();
    }

    // ---------- Larger input ----------

    @Test
    @DisplayName("Memoization: 500-char identical strings (recursion depth stays safe)")
    void largeInputMemoization() {
        String s = "ab".repeat(250);
        assertEquals(500, new Longest_Common_Subsequence().memozation_method(s, s));
    }

    @Test
    @DisplayName("Tabulation: 2000-char strings, no recursion so no stack risk")
    void largeInputTabulation() {
        String s = "abc".repeat(667); // length 2001
        assertEquals(s.length(), new Longest_Common_Subsequence().lcs(s, s));
        // 'a' repeated vs 'b' repeated share nothing
        assertEquals(0, new Longest_Common_Subsequence().lcs("a".repeat(2000), "b".repeat(2000)));
    }
}