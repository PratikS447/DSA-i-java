package org.example.TwoPointer_SlidingWindow;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Longest_repeating_character_Replacement_Test {
    private String makeTest(int k, String s){
        return s;
    }

    @Test
    public void standardTestCase(){
        int k = 2;
        String input = makeTest(k, "ABAB");
        assertEquals(4, Longest_repeating_character_Replacement.characterReplacement(input, k));
    }

    @Test
    public void standardTestCase2(){
        int k = 1;
        String input = makeTest(k, "AABABBA");
        assertEquals(4, Longest_repeating_character_Replacement.characterReplacement(input, k));
    }
}
