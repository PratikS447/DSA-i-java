package org.example.TwoPointer_SlidingWindow;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Longest_Substring_Without_Repeating_Char_test {
    private String make_String(String s){
        return s;
    }

    @Test
    public void StandardTestCase1(){
        String s = make_String("abcabcbb");
        assertEquals(3, Longest_Substring_Without_Repeating_Char.length_of_character(s));
    }

    @Test
    public void StandardTestCase2(){
        String s = make_String("bbbbb");
        assertEquals(1, Longest_Substring_Without_Repeating_Char.length_of_character(s));
    }


    public void StandardTestCase3(){
        String s = make_String("pwwkew");
        assertEquals(3, s);
    }
}
