package org.example.TwoPointer_SlidingWindow;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Smallest_SubstringTest {
    private ArrayList<Integer> makeList(Integer... elements){
        return new ArrayList<>(Arrays.asList(elements));
    }

    @Test
    public void testStandardCase(){
        ArrayList<Integer> input = makeList(1, 1, 2, 2, 3, 3, 4, 5);
        int k = 3;
        List<Integer> expected = List.of(5, 7);
        assertEquals(expected, Smallest_Substring.smallestSubarrayWithKDistinct(input, k));
    }

    @Test
    public void testLexicographicalTie(){
        ArrayList<Integer> input = makeList(1, 2, 2, 3, 1, 3);
        int k = 2;
        List<Integer> expected = List.of(0, 1);
        assertEquals(expected, Smallest_Substring.smallestSubarrayWithKDistinct(input, k));
    }

    @Test
    public void testImpossibleScenario() {
        ArrayList<Integer> input = makeList(1, 1, 2, 1, 2);
        int K = 3;
        List<Integer> expected = List.of(-1);
        assertEquals(expected, Smallest_Substring.smallestSubarrayWithKDistinct(input, K));
    }
}
