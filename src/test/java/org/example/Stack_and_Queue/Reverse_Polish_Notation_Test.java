package org.example.Stack_and_Queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Reverse_Polish_Notation_Test {

    @Test
    void testCase1() {
        String[] tokens = {"2","1","+","3","*"};
        assertEquals(9, Reverse_Polish_Notation.eval_RNP(tokens));
    }

    @Test
    void testCase2() {
        String[] tokens = {"4","13","5","/","+"};
        assertEquals(6, Reverse_Polish_Notation.eval_RNP(tokens));
    }

    @Test
    void testCase3() {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        assertEquals(22, Reverse_Polish_Notation.eval_RNP(tokens));
    }

    @Test
    void testCase4() {
        String[] tokens = {"5"};
        assertEquals(5, Reverse_Polish_Notation.eval_RNP(tokens));
    }

    @Test
    void testAddition() {
        String[] tokens = {"2","3","+"};
        assertEquals(5, Reverse_Polish_Notation.eval_RNP(tokens));
    }

    @Test
    void testSubtraction() {
        String[] tokens = {"5","2","-"};
        assertEquals(3, Reverse_Polish_Notation.eval_RNP(tokens));
    }

    @Test
    void testMultiplication() {
        String[] tokens = {"4","5","*"};
        assertEquals(20, Reverse_Polish_Notation.eval_RNP(tokens));
    }

    @Test
    void testDivision() {
        String[] tokens = {"20","4","/"};
        assertEquals(5, Reverse_Polish_Notation.eval_RNP(tokens));
    }

    @Test
    void testComplex() {
        String[] tokens = {"5","1","2","+","4","*","+","3","-"};
        assertEquals(14, Reverse_Polish_Notation.eval_RNP(tokens));
    }
}