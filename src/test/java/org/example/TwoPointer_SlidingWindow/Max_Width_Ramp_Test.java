package org.example.TwoPointer_SlidingWindow;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Max_Width_Ramp_Test {
    private int[] makeTest(int...arr){
        return arr;
    }

    @Test
    public void StandardTestCase(){
        int arr[] = {6,0,8,2,1,5};
        int [] input = makeTest(arr);
        assertEquals(4, Max_Width_Ramp.max_ramp(input));
    }

    @Test
    public void StandardTestCase2(){
        int arr[] = {9,8,1,0,1,9,4,0,4,1};
        int [] input = makeTest(arr);
        assertEquals(7, Max_Width_Ramp.max_ramp(input));
    }
}
