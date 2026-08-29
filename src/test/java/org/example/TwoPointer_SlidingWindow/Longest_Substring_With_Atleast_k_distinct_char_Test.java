package org.example.TwoPointer_SlidingWindow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Longest_Substring_With_Atleast_k_distinct_char_Test {

    @Test
    void testExample1() {
        // "aaabb", k=3 -> "aaa" has 'a' appearing 3 times
        assertEquals(3, Longest_Substring_With_Atleast_k_distinct_char
                .longest_subtring("aaabb", 3));
    }

    @Test
    void testExample2() {
        // "ababbc", k=2 -> "babb" -> a:1,b:3 invalid; "ababb" a:2,b:3 valid -> length 5
        assertEquals(5, Longest_Substring_With_Atleast_k_distinct_char
                .longest_subtring("ababbc", 2));
    }

    @Test
    void testAllCharsMeetK() {
        // every char already appears exactly k times across whole string
        assertEquals(6, Longest_Substring_With_Atleast_k_distinct_char
                .longest_subtring("aabbcc", 2));
    }

    @Test
    void testNoValidSubstring() {
        // k larger than any char's total count
        assertEquals(0, Longest_Substring_With_Atleast_k_distinct_char
                .longest_subtring("abcde", 2));
    }

    @Test
    void testSingleCharacterString() {
        assertEquals(1, Longest_Substring_With_Atleast_k_distinct_char
                .longest_subtring("a", 1));
    }

    @Test
    void testSingleCharacterStringKTooHigh() {
        assertEquals(0, Longest_Substring_With_Atleast_k_distinct_char
                .longest_subtring("a", 2));
    }

    @Test
    void testEmptyString() {
        assertEquals(0, Longest_Substring_With_Atleast_k_distinct_char
                .longest_subtring("", 1));
    }

    @Test
    void testKEqualsOne() {
        // k=1 means every char just needs to appear at least once -> whole string qualifies
        assertEquals(5, Longest_Substring_With_Atleast_k_distinct_char
                .longest_subtring("abcde", 1));
    }

    @Test
    void testAllSameCharacter() {
        assertEquals(5, Longest_Substring_With_Atleast_k_distinct_char
                .longest_subtring("aaaaa", 3));
    }

    @Test
    void testMixedValidAndInvalidSegments() {
        // "aaabbb" with k=3 -> whole string valid (a:3, b:3)
        assertEquals(6, Longest_Substring_With_Atleast_k_distinct_char
                .longest_subtring("aaabbb", 3));
    }

    @Test
    void testWeightedExample() {
        // "weitong", k=2 -> no char repeats twice except nothing; expect 0
        assertEquals(0, Longest_Substring_With_Atleast_k_distinct_char
                .longest_subtring("weitong", 2));
    }
}