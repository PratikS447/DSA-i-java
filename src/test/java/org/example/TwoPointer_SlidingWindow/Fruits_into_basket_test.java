package org.example.TwoPointer_SlidingWindow;

import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Fruits_into_basket_test {
    private int[] makeArray(int...element){
        return element;
    }

    @Test
    public void testStandardCase(){
        int input[] = makeArray(1, 2, 1);
        assertEquals(3, Fruits_into_basket.totalFruit(input));
    }

    @Test
    public void testStandardCase2(){
        int input[] = makeArray(0,1,2,2);
        assertEquals(3, Fruits_into_basket.totalFruit(input));
    }

    @Test
    public void testStandCase3(){
        int input[] = makeArray(1, 2, 3, 2, 2);
        assertEquals(4, Fruits_into_basket.totalFruit(input));
    }
}
