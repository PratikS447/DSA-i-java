package org.example.DynamicProgramming.DP_On_Subsequence;

public class O_1_Knapsack {
    public static int knap_sack(int weight[], int value[], int total_weight){
        return helper(weight, value, 0, total_weight);
    }

    public static int helper(int wt[], int val[], int idx, int req_weight){
        if (req_weight == 0 || idx == wt.length){
            return 0;
        }

        int take = 0;
        if(wt[idx] <=  req_weight){
            take = val[idx]+ helper(wt, val, idx+1, req_weight -wt[idx]);
        }

        int not_take = helper(wt, val, idx+1, req_weight);

        return Math.max(take, not_take);
    }
}
