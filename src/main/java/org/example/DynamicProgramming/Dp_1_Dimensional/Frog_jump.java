package org.example.DynamicProgramming.Dp_1_Dimensional;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Frog_jump {

    public boolean memoization(int[] stones) {
        int n = stones.length;
        Map<Integer, Integer> map = new HashMap<>();
        int memo[][] = new int[n][n+1];
        for(int row[]: memo){
            Arrays.fill(row, -1);
        }

        for(int i = 0; i < n; i++){
            map.put(stones[i], i);
        }
        return helper(stones, 0, 0, map, memo);
    }

    public boolean helper(int stones[], int idx, int jump, Map<Integer, Integer> map, int memo[][]){
        if(idx == stones.length -1){
            return true;
        }

        if(memo[idx][jump] != -1){
            return memo[idx][jump] == 1;
        }

        for(int k = jump -1; k <= jump +1; k++){
            if(k <= 0) continue;

            int next_jump = stones[idx] + k;
            if(map.containsKey(next_jump)){
                int curr_idx = map.get(next_jump);
                if(helper(stones, curr_idx, k, map, memo)){
                    memo[curr_idx][k] = 1;
                    return true;
                }
            }
        }

        memo[idx][jump] = 0;
        return false;
    }

    public boolean tabulation(int[] stones) {
        int n = stones.length;
        int dp[][] = new int[n][n+1];

        if(stones[1] != 1){
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(stones[i], i);
        }

        dp[0][0] = 1;

        for(int i = 0; i < n; i++){
            for(int jump = 0; jump < n+1; jump++){
                if(dp[i][jump] == 1){
                    for(int k = jump -1; k <= jump+1; k++){
                        if(k > 0 && k < n+1){
                            int next_jump = stones[i] + k;
                            if(map.containsKey(next_jump)){
                                int curr_idx = map.get(next_jump);
                                dp[curr_idx][k] = 1;
                            }
                        }
                    }
                }
            }
        }

        for(int i = 0; i < n+1; i++){
            if(dp[n-1][i] == 1){
                return true;
            }
        }

        return false;
    }
}