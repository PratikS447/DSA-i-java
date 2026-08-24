package org.example.Backtracking_and_recusion.Recursion;

public class Atoi {

    static final int INT_MAX = Integer.MAX_VALUE;
    static final int INT_MIN = Integer.MIN_VALUE;

    public static int myAtoi(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        int i = 0;
        int n = s.length();

        // CHECK FOR WHITESPACE
        while (i < n && s.charAt(i) == ' '){
            i++;
        }

        // CHECK FOR ONLY WHITESPACE
        if (i == n){
            return 0;
        }

        // SIGN CHECK
        int sign = 1;
        if(s.charAt(i) == '-'){
            sign = -1;
            i++;
        }else if(s.charAt(i) == '+') {
            sign = 1;
            i++;
        }

        long res = helper(s, i, 0);

        if(sign == 1){
            return (int)Math.min(res, INT_MAX);
        }
        else{
            return (int)Math.max(-res, INT_MIN);
        }
    }

    public static long helper(String s, int i, int ans){
        if(i >= s.length() || !Character.isDigit(s.charAt(i))){
            return ans;
        }

        int digit = s.charAt(i) - '0';
        ans = ans*10 + digit;

        if((long)INT_MAX + 1 < ans){
            return (long) INT_MAX+1;
        }

        return helper(s, i+1, ans);
    }

    public static void main(String args[]){
        System.out.println(myAtoi("1337c0d3"));        // Output: 1337
        System.out.println(myAtoi("   -42"));          // Output: -42
        System.out.println(myAtoi("4193 with words")); // Output: 4193
        System.out.println(myAtoi("9999999999999"));   // Output: 2147483647
    }
}
