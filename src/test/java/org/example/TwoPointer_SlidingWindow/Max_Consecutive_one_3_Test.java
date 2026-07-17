package org.example.TwoPointer_SlidingWindow;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Max_Consecutive_one_3_Test {
    private int[] makeElement( int k, int...arr){
        return arr;
    }

    @Test
    public void standardTestCase(){
        int k = 2;
        int input[] = {1,1,0,0,0,1,1,1,1,0};
        makeElement(k, input);
        assertEquals(6, Max_Consecutive_ones_3.consecutive_one(input, k));
    }

    @Test
    public void standardTestCase2(){
        int k = 3;
        int input[] = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        makeElement(k, input);
        assertEquals(10, Max_Consecutive_ones_3.consecutive_one(input, k));
    }
}
