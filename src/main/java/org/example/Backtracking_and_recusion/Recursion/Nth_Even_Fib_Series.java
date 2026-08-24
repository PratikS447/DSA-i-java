package org.example.Backtracking_and_recusion.Recursion;

public class Nth_Even_Fib_Series {
    public static int even_Fib(int n){
        if(n == 0) return 2;
        if(n == 1) return 8;

        return 4*even_Fib(n-1) + even_Fib(n-2);
    }

    public static void main(String args[]){
        System.out.print(even_Fib(0));
    }
}
