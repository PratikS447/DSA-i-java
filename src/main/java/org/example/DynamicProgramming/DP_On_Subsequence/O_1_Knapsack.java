package org.example.DynamicProgramming.DP_On_Subsequence;

import java.util.Arrays;

public class O_1_Knapsack {
    public static int knap_sack(int weight[], int value[], int total_weight){
        int n = weight.length;
        int memo[][] = new int[n][total_weight+1];
        for(int m[]: memo){
            Arrays.fill(m, -1);
        }
        return helper(weight, value, 0, total_weight, memo);
    }

    public static int helper(int wt[], int val[], int idx, int req_weight, int memo[][]){
        if (req_weight == 0 || idx == wt.length){
            return 0;
        }

        if(memo[idx][req_weight] != -1){
            return memo[idx][req_weight];
        }

        int take = 0;
        if(wt[idx] <=  req_weight){
            take = val[idx]+ helper(wt, val, idx+1, req_weight -wt[idx], memo);
        }

        int not_take = helper(wt, val, idx+1, req_weight, memo);

        return memo[idx][req_weight] = Math.max(take, not_take);
    }
}
