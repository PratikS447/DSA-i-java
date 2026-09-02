package org.example.HashMap;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Longest_Repeating_Character_Replacement_Test {

    @Test
    void basicCase() {
        assertEquals(4, Longest_Repeating_Character_Replacement.longest_repeating("ABAB", 2));
    }

    @Test
    void classicLeetCodeExample() {
        assertEquals(4, Longest_Repeating_Character_Replacement.longest_repeating("AABABBA", 1));
    }

    @Test
    void noRepeatsPossible() {
        // k=1 replacement, max window with one dominant char is 2
        assertEquals(2, Longest_Repeating_Character_Replacement.longest_repeating("ABCDE", 1));
    }

    @Test
    void allSameCharacters() {
        assertEquals(4, Longest_Repeating_Character_Replacement.longest_repeating("AAAA", 0));
    }

    @Test
    void kIsZeroWithMix() {
        // no replacements allowed -> longest run of same char
        assertEquals(2, Longest_Repeating_Character_Replacement.longest_repeating("AABA", 0));
    }

    @Test
    void kCoversEntireString() {
        assertEquals(5, Longest_Repeating_Character_Replacement.longest_repeating("ABCDE", 4));
    }

    @Test
    void kLargerThanNeeded() {
        assertEquals(5, Longest_Repeating_Character_Replacement.longest_repeating("ABCDE", 100));
    }

    @Test
    void singleCharacterString() {
        assertEquals(1, Longest_Repeating_Character_Replacement.longest_repeating("A", 0));
        assertEquals(1, Longest_Repeating_Character_Replacement.longest_repeating("A", 5));
    }

    @Test
    void emptyString() {
        assertEquals(0, Longest_Repeating_Character_Replacement.longest_repeating("", 2));
    }

    @Test
    void trailingReplacementCase() {
        assertEquals(4, Longest_Repeating_Character_Replacement.longest_repeating("ABBB", 2));
    }

    @Test
    void twoDistinctCharsFullReplace() {
        assertEquals(1, Longest_Repeating_Character_Replacement.longest_repeating("AB", 0)); // fixed
        assertEquals(2, Longest_Repeating_Character_Replacement.longest_repeating("AB", 1)); // still correct
    }

    @Test
    void longerMixedCase() {
        // "BBBBABAAAAB" k=2 -> answer 8 (well-known LC test)
        assertEquals(7, Longest_Repeating_Character_Replacement.longest_repeating("BBBBABAAAAB", 2));
    }
}