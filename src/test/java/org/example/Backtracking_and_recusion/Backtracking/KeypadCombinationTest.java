package org.example.Backtracking_and_recusion.Backtracking;

import org.example.Backtracking_and_recusion.backtracking.KeypadCombination;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KeypadCombinationTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void testPrintKPCWithSingleDigit() {
        KeypadCombination.printKPC("1");
        // '1' maps to "abc" -> expected output: a, b, c each on a new line
        String expected = "a" + System.lineSeparator() + 
                          "b" + System.lineSeparator() + 
                          "c" + System.lineSeparator();
        assertEquals(expected, outputStreamCaptor.toString());
    }

    @Test
    public void testPrintKPCWithZeroDigit() {
        KeypadCombination.printKPC("0");
        // '0' maps to ".;" -> expected output: ., ; each on a new line
        String expected = "." + System.lineSeparator() + 
                          ";" + System.lineSeparator();
        assertEquals(expected, outputStreamCaptor.toString());
    }

    @Test
    public void testPrintKPCWithEmptyString() {
        KeypadCombination.printKPC("");
        String expected = System.lineSeparator();
        assertEquals(expected, outputStreamCaptor.toString());
    }
}