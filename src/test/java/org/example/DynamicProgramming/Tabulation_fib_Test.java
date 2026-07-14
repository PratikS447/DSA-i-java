package org.example.DynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tabulation_fib_Test {

    Tabulation_fib fib = new Tabulation_fib();

    @Test
    public void testFibZero(){
        assertEquals(0, fib.fib_series(0));
    }

    @Test
    public void testFibOne(){
        assertEquals(1, fib.fib_series(1));
    }

}
