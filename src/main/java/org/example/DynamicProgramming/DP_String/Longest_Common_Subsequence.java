package org.example.DynamicProgramming.DP_String;

import java.util.Arrays;

class Longest_Common_Subsequence {
    public int memozation_method(String s1, String s2) {
        // code here
        int n = s1.length();
        int m = s2.length();
        int memo[][] = new int[n+1][m+1];
        for(int row[]: memo){
            Arrays.fill(row, -1);
        }
        return helper(s1, n-1, s2, m-1, memo);
    }
    
    public int helper(String s1, int n, String s2, int m, int memo[][]){
        if(n < 0 || m < 0){
            return 0;
        }
        
        if(memo[n][m] != -1){
            return memo[n][m];
        }
        
        int ans;
        if(s1.charAt(n) == s2.charAt(m)){
            ans = 1 + helper(s1, n-1, s2, m-1, memo);
        }else{
            ans = Math.max(helper(s1, n-1, s2, m, memo), helper(s1, n, s2, m-1, memo));
        }
        
        memo[n][m] = ans;
        return memo[n][m];
    }

    public int lcs(String s1, String s2) {
        // code here
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n+1][m+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] +1;
                }else{
                    int take_i = dp[i-1][j];
                    int take_j = dp[i][j-1];
                    dp[i][j] = Math.max(take_i, take_j);
                }
            }
        }

        return dp[n][m];
    }
}