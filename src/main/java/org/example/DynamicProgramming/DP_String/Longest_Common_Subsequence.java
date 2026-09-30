package org.example.DynamicProgramming.DP_String;

public class Longest_Common_Subsequence {
    public static int longest_subsequence(String str1, String str2){
        return helper(str1, str2, str1.length() -1, str2.length() -1);
    }

    public static int helper(String str1, String str2, int n, int m){
        if(n < 0 || m < 0){
            return 0;
        }

        if(str1.charAt(n) == str2.charAt(m)){
            return 1 + helper(str1, str2, n-1, m-1);
        }else {
            return Math.max(helper(str1, str2, n-1, m), helper(str1, str2, n, m-1));
        }
    }
}
