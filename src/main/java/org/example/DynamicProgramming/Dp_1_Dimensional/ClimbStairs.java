package org.example.DynamicProgramming.Dp_1_Dimensional;

import java.util.Arrays;

class ClimbStairs {
    public int climbStairs(int n) {
        int memo[] = new int[n+1];
        Arrays.fill(memo, -1);
        return helper(n, memo);
    }

    public int helper(int n, int memo[]){
        if(n == 1 || n == 2){
            return n;
        }

        if(memo[n] != -1){
            return memo[n];
        }

        return memo[n] = helper(n-1, memo) + helper(n-2, memo);
    }
}