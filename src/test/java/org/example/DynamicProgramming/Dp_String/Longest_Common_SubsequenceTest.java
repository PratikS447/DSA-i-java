package org.example.DynamicProgramming.Dp_String;

// NOTE: this package is "Dp_String" but the import below uses "DP_String" (different casing).
// It works on case-insensitive filesystems (default macOS) but breaks on Linux/CI.
// Use the same casing in both places. Also, the class under test must be public
// because the test lives in a different package than the class.
import org.example.DynamicProgramming.DP_String.Longest_Common_Subsequence;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.function.BiFunction;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests both LCS implementations (memoization + tabulation).
 * Known input/output pairs live in src/test/resources/lcs_cases.csv; logic-based tests stay in Java.
 */
class Longest_Common_SubsequenceTest {

    private static final String MEMO = "memoization";
    private static final String TABULATION = "tabulation";

    // ---------- Provider ----------

    /** The two implementations under test. A new instance per call keeps tests independent. */
    static Stream<Named<BiFunction<String, String, Integer>>> implementations() {
        return Stream.of(
                Named.of(MEMO, (a, b) -> new Longest_Common_Subsequence().memozation_method(a, b)),
                Named.of(TABULATION, (a, b) -> new Longest_Common_Subsequence().lcs(a, b))
        );
    }

    // ---------- Known input/output pairs (from CSV) ----------

    @ParameterizedTest(name = "{3}: LCS(\"{0}\", \"{1}\") = {2}")
    @CsvFileSource(resources = "/DynamicProgramming/DP_On_String/lcs_cases.csv", numLinesToSkip = 1, encoding = "UTF-8")
    @DisplayName("Known cases loaded from lcs_cases.csv (both implementations)")
    void knownCasesFromCsv(String s1, String s2, int expected, String description) {
        assertEquals(expected, new Longest_Common_Subsequence().memozation_method(s1, s2));
        assertEquals(expected, new Longest_Common_Subsequence().lcs(s1, s2));
    }

    // ---------- Edge cases ----------
    // Empty strings stay in Java: an empty CSV cell is read as null, which would need extra handling.

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