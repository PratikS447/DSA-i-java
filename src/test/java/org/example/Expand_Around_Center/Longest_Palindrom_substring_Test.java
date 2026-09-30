package org.example.Expand_Around_Center;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Longest_Palindrom_substring_Test {
    // edge cases

    @Test
    void emptyString_returnsEmpty(){
        assertEquals("", Longest_Palindrom_substring.longest_substring(""));
    }
    @Test
    void singleCharacter_returnsItself(){
        assertEquals("a", Longest_Palindrom_substring.longest_substring("a"));
    }

    @Test
    void Two_length_Valid_substring(){
        assertEquals("aa", Longest_Palindrom_substring.longest_substring("aa"));
    }

    @Test
    void Multiple_Valid_Longest_Palindrom_For_Ab(){
        String result = Longest_Palindrom_substring.longest_substring("ab");
        List<String> validOutput = Arrays.asList("a", "b");

        assertTrue(validOutput.contains(result), () -> "Expected 'a' && 'b' got : "+result);
    }

    @Test
    void for_bab(){
        String result = Longest_Palindrom_substring.longest_substring("babad");
        List<String> validOutput = Arrays.asList("bab", "aba");

        assertTrue(validOutput.contains(result), () -> "Expect 'bab' && 'aba' got : "+result);
    }

    @Test
    void for_cbbd(){
        String result = Longest_Palindrom_substring.longest_substring("cbbd");
        List<String> valid_output = Arrays.asList("bb");

        assertTrue(valid_output.contains(result), result);
    }
}
