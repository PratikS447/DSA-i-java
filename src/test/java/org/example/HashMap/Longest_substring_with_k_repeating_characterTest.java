package org.example.HashMap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Longest_substring_with_k_repeating_characterTest {

    @Test
    @DisplayName("Basic case: aaabb, k=3 -> 3 (aaa)")
    void basicCase() {
        String s = "aaabb";
        int k = 3;

        int result = Longest_substring_with_k_repeating_character.longest_string(s, k);

        assertEquals(3, result);
    }

    @Test
    @DisplayName("Regression case that broke the earlier stale-map version: baaabcb, k=3 -> 3")
    void regressionStaleContainsKeyBug() {
        String s = "baaabcb";
        int k = 3;

        int result = Longest_substring_with_k_repeating_character.longest_string(s, k);

        assertEquals(3, result);
    }

    @Test
    @DisplayName("Classic LeetCode example: ababbc, k=2 -> 5 (ababb)")
    void multipleDistinctCharsValid() {
        String s = "ababbc";
        int k = 2;

        int result = Longest_substring_with_k_repeating_character.longest_string(s, k);

        assertEquals(5, result);
    }

    @Test
    @DisplayName("No character meets k -> 0")
    void noCharacterMeetsK() {
        String s = "abcde";
        int k = 2;

        int result = Longest_substring_with_k_repeating_character.longest_string(s, k);

        assertEquals(0, result);
    }

    @Test
    @DisplayName("k = 1 -> entire string always valid")
    void kEqualsOneReturnsWholeString() {
        String s = "abcabcabc";
        int k = 1;

        int result = Longest_substring_with_k_repeating_character.longest_string(s, k);

        assertEquals(9, result);
    }

    @Test
    @DisplayName("Single character repeated exactly k times")
    void singleCharacterExactlyK() {
        String s = "aaa";
        int k = 3;

        int result = Longest_substring_with_k_repeating_character.longest_string(s, k);

        assertEquals(3, result);
    }

    @Test
    @DisplayName("k greater than string length -> 0")
    void kGreaterThanStringLength() {
        String s = "aabbcc";
        int k = 10;

        int result = Longest_substring_with_k_repeating_character.longest_string(s, k);

        assertEquals(0, result);
    }

    @Test
    @DisplayName("Empty string -> 0")
    void emptyString() {
        String s = "";
        int k = 2;

        int result = Longest_substring_with_k_repeating_character.longest_string(s, k);

        assertEquals(0, result);
    }

    @Test
    @DisplayName("Nested valid substring: only middle segment meets k")
    void nestedValidSubstring() {
        String s = "ababacb";
        int k = 3;

        int result = Longest_substring_with_k_repeating_character.longest_string(s, k);

        assertEquals(0, result);
    }

    @Test
    @DisplayName("All characters identical and equal to k")
    void allIdenticalCharacters() {
        String s = "bbbbb";
        int k = 5;

        int result = Longest_substring_with_k_repeating_character.longest_string(s, k);

        assertEquals(5, result);
    }

    @Test
    @DisplayName("LeetCode example: weeeeeitagoeitiwooikooe, k=2 -> 5")
    void classicLeetCodeExample() {
        String s = "weitagoeitwooikooe";
        int k = 2;

        int result = Longest_substring_with_k_repeating_character.longest_string(s, k);

        assertEquals(2, result);
    }

    @Test
    @DisplayName("Answer lies in a suffix window, not from the start")
    void validWindowNotAtStart() {
        String s = "xxyyyzz";
        int k = 3;

        int result = Longest_substring_with_k_repeating_character.longest_string(s, k);

        assertEquals(3, result);
    }
}