package org.example.Stack_and_Queue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Balanced_Expression_Test {

    @Test
    @DisplayName("Empty string is balanced")
    void emptyString() {
        // Arrange
        String input = "";

        // Act
        boolean result = Balanced_Expression.is_balanced(input);

        // Assert
        assertTrue(result);
    }

    @Test
    @DisplayName("Single pair of each bracket type is balanced")
    void singlePairsBalanced() {
        assertTrue(Balanced_Expression.is_balanced("()"));
        assertTrue(Balanced_Expression.is_balanced("[]"));
        assertTrue(Balanced_Expression.is_balanced("{}"));
    }

    @Test
    @DisplayName("Nested brackets of same type are balanced")
    void nestedSameType() {
        assertTrue(Balanced_Expression.is_balanced("(((())))"));
    }

    @Test
    @DisplayName("Nested brackets of mixed types are balanced")
    void nestedMixedTypes() {
        assertTrue(Balanced_Expression.is_balanced("{[()]}"));
    }

    @Test
    @DisplayName("Sequential (non-nested) brackets are balanced")
    void sequentialBrackets() {
        assertTrue(Balanced_Expression.is_balanced("()[]{}"));
    }

    @Test
    @DisplayName("Brackets embedded in surrounding text/code are balanced")
    void embeddedInText() {
        // non-bracket chars should be stripped and ignored
        assertTrue(Balanced_Expression.is_balanced("foo(bar[baz]{qux})"));
    }

    @Test
    @DisplayName("Unclosed opening bracket is not balanced")
    void unclosedOpening() {
        assertFalse(Balanced_Expression.is_balanced("(("));
        assertFalse(Balanced_Expression.is_balanced("{[}"));
    }

    @Test
    @DisplayName("Unmatched closing bracket with empty stack is not balanced")
    void unmatchedClosingOnEmptyStack() {
        assertFalse(Balanced_Expression.is_balanced(")"));
        assertFalse(Balanced_Expression.is_balanced("())"));
    }

    @Test
    @DisplayName("Extra trailing closing bracket is not balanced")
    void extraClosingBracket() {
        assertFalse(Balanced_Expression.is_balanced("()]"));
    }

    @Test
    @DisplayName("Wrong bracket type closing an open one is not balanced")
    void mismatchedBracketType() {
        // BUG: current implementation returns true for this input.
        // When the closing bracket doesn't match st.peek(), the code
        // silently does nothing instead of returning false, so the
        // mismatch goes undetected. This test documents the expected
        // (correct) behavior and will fail against the code as written.
        assertFalse(Balanced_Expression.is_balanced("(]"));
        assertFalse(Balanced_Expression.is_balanced("{(})"));
    }

    @Test
    @DisplayName("Reversed order of same bracket type is not balanced")
    void reversedOrderSameType() {
        assertFalse(Balanced_Expression.is_balanced(")("));
    }
}