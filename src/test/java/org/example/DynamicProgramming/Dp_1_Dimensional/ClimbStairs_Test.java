package org.example.DynamicProgramming.Dp_1_Dimensional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ClimbStairs_Test {

    @Test
    @DisplayName("n = 1 has exactly one way")
    void oneStair() {
        // Arrange
        ClimbStairs cs = new ClimbStairs();

        // Act
        int result = cs.climbStairs(1);

        // Assert
        assertEquals(1, result);
    }

    @Test
    @DisplayName("n = 2 has exactly two ways")
    void twoStairs() {
        ClimbStairs cs = new ClimbStairs();
        assertEquals(2, cs.climbStairs(2));
    }

    @Test
    @DisplayName("n = 3 has exactly three ways")
    void threeStairs() {
        ClimbStairs cs = new ClimbStairs();
        assertEquals(3, cs.climbStairs(3));
    }

    @Test
    @DisplayName("n = 4 has exactly five ways")
    void fourStairs() {
        ClimbStairs cs = new ClimbStairs();
        assertEquals(5, cs.climbStairs(4));
    }

    @Test
    @DisplayName("n = 5 has exactly eight ways")
    void fiveStairs() {
        ClimbStairs cs = new ClimbStairs();
        assertEquals(8, cs.climbStairs(5));
    }

    @Test
    @DisplayName("n = 10 follows Fibonacci-like growth")
    void tenStairs() {
        ClimbStairs cs = new ClimbStairs();
        assertEquals(89, cs.climbStairs(10));
    }

    @Test
    @DisplayName("Larger n (20) still computes correctly with memoization")
    void twentyStairs() {
        ClimbStairs cs = new ClimbStairs();
        assertEquals(10946, cs.climbStairs(20));
    }

    @Test
    @DisplayName("Upper bound of constraints (n = 45) returns without overflow or stack issues")
    void maxConstraintStairs() {
        ClimbStairs cs = new ClimbStairs();
        assertEquals(1836311903, cs.climbStairs(45));
    }

    @Test
    @DisplayName("n = 0 is outside stated constraints and currently throws")
    void zeroStairsEdgeCase() {
        // Documents current behavior rather than asserting "correct" output,
        // since the problem constraints guarantee n >= 1. If you want
        // climbStairs(0) to return 1 instead of throwing, you'd need to
        // add an explicit n == 0 base case.
        ClimbStairs cs = new ClimbStairs();
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> cs.climbStairs(0));
    }
}