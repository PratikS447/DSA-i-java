package org.example.TwoPointer_SlidingWindow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestDistinctCharacterTest {

    @Test
    @DisplayName("Empty string returns 0, not Integer.MIN_VALUE")
    void testEmptyString() {
        // Arrange
        String str = "";

        // Act
        int result = Longest_Distinct_Character.longest(str);

        // Assert
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Single character string returns 1")
    void testSingleCharacter() {
        // Arrange
        String str = "a";

        // Act
        int result = Longest_Distinct_Character.longest(str);

        // Assert
        assertEquals(1, result);
    }

    @Test
    @DisplayName("All unique characters returns full length")
    void testAllUniqueCharacters() {
        // Arrange
        String str = "abcdef";

        // Act
        int result = Longest_Distinct_Character.longest(str);

        // Assert
        assertEquals(6, result);
    }

    @Test
    @DisplayName("All same character returns 1")
    void testAllSameCharacter() {
        // Arrange
        String str = "aaaaaa";

        // Act
        int result = Longest_Distinct_Character.longest(str);

        // Assert
        assertEquals(1, result);
    }

    @Test
    @DisplayName("Classic example: abcabcbb -> longest is abc (3)")
    void testClassicExample1() {
        // Arrange
        String str = "abcabcbb";

        // Act
        int result = Longest_Distinct_Character.longest(str);

        // Assert
        assertEquals(3, result);
    }

    @Test
    @DisplayName("Classic example: bbbbb -> longest is b (1)")
    void testClassicExample2() {
        // Arrange
        String str = "bbbbb";

        // Act
        int result = Longest_Distinct_Character.longest(str);

        // Assert
        assertEquals(1, result);
    }

    @Test
    @DisplayName("Classic example: pwwkew -> longest is wke (3)")
    void testClassicExample3() {
        // Arrange
        String str = "pwwkew";

        // Act
        int result = Longest_Distinct_Character.longest(str);

        // Assert
        assertEquals(3, result);
    }

    @Test
    @DisplayName("Longest window is in the middle of the string")
    void testLongestWindowInMiddle() {
        // Arrange: "ab" repeats, then "cdefg" is the longest unique run
        String str = "ababcdefgab";

        // Act
        int result = Longest_Distinct_Character.longest(str);

        // Assert
        assertEquals(7, result); // "abcdefg"
    }

    @Test
    @DisplayName("Repeat character at the very end shrinks correctly")
    void testRepeatAtEnd() {
        // Arrange
        String str = "abcda";

        // Act
        int result = Longest_Distinct_Character.longest(str);

        // Assert
        assertEquals(4, result); // "abcd"
    }
}