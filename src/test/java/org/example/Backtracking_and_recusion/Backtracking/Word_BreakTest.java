package org.example.Backtracking_and_recusion.Backtracking;

import org.example.Backtracking_and_recusion.backtracking.Word_Break;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Word_BreakTest {

    private final Word_Break solution = new Word_Break();

    @Test
    @DisplayName("Basic case: string breaks into two dictionary words")
    void testBasicTwoWordBreak() {
        String[] dict = {"leet", "code"};
        assertTrue(solution.word_break("leetcode", dict));
    }

    @Test
    @DisplayName("String breaks into multiple dictionary words")
    void testMultipleWordBreak() {
        String[] dict = {"cats", "cat", "sand", "and", "dog"};
        assertTrue(solution.word_break("catsanddog", dict));
    }

    @Test
    @DisplayName("String cannot be segmented with given dictionary")
    void testNoValidBreak() {
        String[] dict = {"cats", "dog", "sand", "and", "cat"};
        assertFalse(solution.word_break("catsandog", dict));
    }

    @Test
    @DisplayName("Classic exponential-blowup case without memoization would TLE")
    void testAmbiguousSegmentationNoBreak() {
        String[] dict = {"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"};
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        assertFalse(solution.word_break(s, dict));
    }

    @Test
    @DisplayName("Whole string itself is a single dictionary word")
    void testWholeStringIsSingleWord() {
        String[] dict = {"apple", "banana"};
        assertTrue(solution.word_break("apple", dict));
    }

    @Test
    @DisplayName("Empty string returns true trivially")
    void testEmptyString() {
        String[] dict = {"a", "b"};
        assertTrue(solution.word_break("", dict));
    }

    @Test
    @DisplayName("Single character not in dictionary returns false")
    void testSingleCharNotInDict() {
        String[] dict = {"b", "c"};
        assertFalse(solution.word_break("a", dict));
    }

    @Test
    @DisplayName("Dictionary word longer than string never matches")
    void testDictWordLongerThanString() {
        String[] dict = {"abcdef"};
        assertFalse(solution.word_break("abc", dict));
    }

    @Test
    @DisplayName("Overlapping/ambiguous segmentation still finds valid break")
    void testAmbiguousButValidBreak() {
        String[] dict = {"pen", "pineapple", "apple", "pine"};
        assertTrue(solution.word_break("pineapplepenapple", dict));
    }

    @Test
    @DisplayName("Repeated word usage allowed (word used more than once)")
    void testRepeatedWordUsage() {
        String[] dict = {"ab"};
        assertTrue(solution.word_break("abab", dict));
    }
}