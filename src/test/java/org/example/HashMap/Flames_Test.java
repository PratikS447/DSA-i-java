package org.example.HashMap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Flames_Test {

    @Test
    @DisplayName("Given example: saumya & ansh -> Siblings")
    void testGivenExample() {
        // Arrange
        String s1 = "saumya";
        String s2 = "ansh";

        // Act
        String result = Flames.flames(s1, s2);

        // Assert
        assertEquals("Siblings", result);
    }

    @Test
    @DisplayName("Identical strings -> everything cancels -> Siblings")
    void testIdenticalStrings() {
        // Arrange
        String s1 = "pratik";
        String s2 = "pratik";

        // Act
        String result = Flames.flames(s1, s2);

        // Assert
        assertEquals("Siblings", result);
    }

    @Test
    @DisplayName("No common characters -> remaining = combined length")
    void testNoCommonCharacters() {
        // Arrange
        String s1 = "abc"; // len 3
        String s2 = "xyz"; // len 3, total remaining = 6, 6 % 6 = 0

        // Act
        String result = Flames.flames(s1, s2);

        // Assert
        assertEquals("Siblings", result);
    }

    @Test
    @DisplayName("Remaining count % 6 == 1 -> Friends")
    void testFriends() {
        // Arrange
        String s1 = "a";
        String s2 = "";

        // Act
        String result = Flames.flames(s1, s2);

        // Assert
        assertEquals("Friends", result);
    }

    @Test
    @DisplayName("Remaining count % 6 == 2 -> Love")
    void testLove() {
        // Arrange
        String s1 = "ab";
        String s2 = "";

        // Act
        String result = Flames.flames(s1, s2);

        // Assert
        assertEquals("Love", result);
    }

    @Test
    @DisplayName("Remaining count % 6 == 3 -> Affection")
    void testAffection() {
        // Arrange
        String s1 = "abc";
        String s2 = "";

        // Act
        String result = Flames.flames(s1, s2);

        // Assert
        assertEquals("Affection", result);
    }

    @Test
    @DisplayName("Remaining count % 6 == 4 -> Marriage")
    void testMarriage() {
        // Arrange
        String s1 = "abcd";
        String s2 = "";

        // Act
        String result = Flames.flames(s1, s2);

        // Assert
        assertEquals("Marriage", result);
    }

    @Test
    @DisplayName("Remaining count % 6 == 5 -> Enemy")
    void testEnemy() {
        // Arrange
        String s1 = "abcde";
        String s2 = "";

        // Act
        String result = Flames.flames(s1, s2);

        // Assert
        assertEquals("Enemy", result);
    }

    @Test
    @DisplayName("Duplicate letters counted per occurrence, not just presence")
    void testDuplicateLettersHandledCorrectly() {
        // Arrange: s1="aab" (a:2,b:1), s2="a" (a:1)
        // diff: a -> 2-1=1, b -> 1-0=1 => remaining = 2
        String s1 = "aab";
        String s2 = "a";

        // Act
        String result = Flames.flames(s1, s2);

        // Assert
        assertEquals("Love", result);
    }

    @Test
    @DisplayName("One empty string -> remaining equals other string's length")
    void testOneEmptyString() {
        // Arrange: len 6 -> 6 % 6 = 0
        String s1 = "abcdef";
        String s2 = "";

        // Act
        String result = Flames.flames(s1, s2);

        // Assert
        assertEquals("Siblings", result);
    }

    @Test
    @DisplayName("Both strings empty -> remaining = 0 -> Siblings")
    void testBothEmpty() {
        // Arrange
        String s1 = "";
        String s2 = "";

        // Act
        String result = Flames.flames(s1, s2);

        // Assert
        assertEquals("Siblings", result);
    }
}