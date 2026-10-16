package org.example.DynamicProgramming.DP_On_Subsequence;

import java.util.Arrays;

public class Longest_Subsequence_With_Adj_Diff_1 {
    static int n;
    public static int subequenct_with_diff_1(int arr[]){
        n = arr.length;
        int memo[][] = new int[n][n+1];
        for (int row[]: memo){
            Arrays.fill(row, -1);
        }
        return helper(arr, 0, -1, memo);
    }

    public static int helper(int arr[], int idx, int prev, int memo[][]){
        if (idx == arr.length){
            return 0;
        }

        if (memo[idx][prev+1] != -1){
            return memo[idx][prev+1];
        }

        int take = 0;
        if(prev == -1 || Math.abs(arr[idx] -arr[prev]) == 1){
            take =  1 + helper(arr, idx+1, idx, memo);
        }

        int not_take = helper(arr, idx+1, prev, memo);

        return memo[idx][prev+1] = Math.max(take, not_take);
    }
}
