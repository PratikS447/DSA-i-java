package org.example.DynamicProgramming;

public class Fibonacci_Memo {
    public static int rec(int n){
        int memo[] = new int[n+1];
        for (int i = 0; i < n+1; i++){
            memo[i] = -1;
        }
        return helper(n, memo);
    }

    public static int helper(int n, int memo[]){
        if(memo[n] != -1) return memo[n];

        if(n == 0 || n == 1) return n;

        memo[n] = helper(n-1, memo) + helper(n-2, memo);

        return memo[n];
    }

}
