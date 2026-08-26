package org.example.TwoPointer_SlidingWindow;

import org.example.HashMap.Longest_Substring_K_Repeating_Character;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestSubstringKRepeatingCharacterTest {

    @Test
    @DisplayName("Example 1: aaabb, k=3 -> longest is 'aaa'")
    void testExample1() {
        // Arrange
        String str = "aaabb";
        int k = 3;

        // Act
        int result = Longest_Substring_K_Repeating_Character.longest_substring(str, k);

        // Assert
        assertEquals(3, result);
    }

    @Test
    @DisplayName("Example 2: ababbc, k=2 -> longest is 'ababb'")
    void testExample2() {
        // Arrange
        String str = "ababbc";
        int k = 2;

        // Act
        int result = Longest_Substring_K_Repeating_Character.longest_substring(str, k);

        // Assert
        assertEquals(5, result);
    }

    @Test
    @DisplayName("No character meets k -> returns 0")
    void testNoValidSubstring() {
        // Arrange: every char appears once
        String str = "abcdef";
        int k = 2;

        // Act
        int result = Longest_Substring_K_Repeating_Character.longest_substring(str, k);

        // Assert
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Entire string already satisfies k -> whole string returned")
    void testWholeStringValid() {
        // Arrange
        String str = "aaaa";
        int k = 2;

        // Act
        int result = Longest_Substring_K_Repeating_Character.longest_substring(str, k);

        // Assert
        assertEquals(4, result);
    }

    @Test
    @DisplayName("k = 1 -> every character satisfies trivially, whole string is valid")
    void testKEqualsOne() {
        // Arrange
        String str = "abcabc";
        int k = 1;

        // Act
        int result = Longest_Substring_K_Repeating_Character.longest_substring(str, k);

        // Assert
        assertEquals(6, result);
    }

    @Test
    @DisplayName("Single character string with k=1 returns length 1")
    void testSingleCharacter() {
        // Arrange
        String str = "a";
        int k = 1;

        // Act
        int result = Longest_Substring_K_Repeating_Character.longest_substring(str, k);

        // Assert
        assertEquals(1, result);
    }

    @Test
    @DisplayName("Single character string with k=2 returns 0 (not enough repeats)")
    void testSingleCharacterInsufficientK() {
        // Arrange
        String str = "a";
        int k = 2;

        // Act
        int result = Longest_Substring_K_Repeating_Character.longest_substring(str, k);

        // Assert
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Multiple splitters require recursive splitting on both sides")
    void testMultipleSplitters() {
        // Arrange: 'x' and 'z' both appear once, splitting the string into three parts
        String str = "aaaxbbbbzcccc";
        int k = 3;

        // Act
        int result = Longest_Substring_K_Repeating_Character.longest_substring(str, k);

        // Assert: "bbbb" (4) and "cccc" (4) tie; "aaa" (3) is smaller
        assertEquals(4, result);
    }

    @Test
    @DisplayName("k greater than string length -> returns 0 immediately via base case")
    void testKGreaterThanLength() {
        // Arrange
        String str = "abc";
        int k = 10;

        // Act
        int result = Longest_Substring_K_Repeating_Character.longest_substring(str, k);

        // Assert
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Nested splitting: valid substring is not at the start or end")
    void testValidSubstringInMiddle() {
        // Arrange: 'a' appears once at each end, disqualifying the outer chars
        String str = "abbbbbbbbba";
        int k = 5;

        // Act
        int result = Longest_Substring_K_Repeating_Character.longest_substring(str, k);

        // Assert: "bbbbbbbbb" has 9 b's, all >= 5
        assertEquals(9, result);
    }
}