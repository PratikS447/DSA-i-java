package org.example.DynamicProgramming.Dp_String;

import org.example.DynamicProgramming.DP_String.Longest_Common_Subsequence;
import org.example.Expand_Around_Center.Longest_Palindrom_substring;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Longest_Common_Subsequence_Test {
    @Test
    public void three_length_subsequence(){
        assertEquals(3, Longest_Common_Subsequence.longest_subsequence("abcde", "ace"));
    }

    @Test
    public void equal_substring(){
        assertEquals(3, Longest_Common_Subsequence.longest_subsequence("abc", "abc"));
    }

    @Test
    public void recurrsive_test_case(){
        assertEquals(4, Longest_Common_Subsequence.longest_subsequence("pmjghexybyrgzczy", "hafcdqbgncrcbihkd"));
    }
}
