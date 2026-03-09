package org.example.Backtracking;

public class StairCase {
    public static void printStair(String str, int n){
        StringBuilder ans = new StringBuilder("");
        helper(ans, n);
    }
    public static void helper(StringBuilder sb, int n){
        if(n == 0){
            System.out.println(sb.toString());
            return;
        }

        if(n >= 1){
            sb.append('1');
            helper(sb, n-1);
            sb.deleteCharAt(sb.length() -1);
        }

        if(n >= 2){
            sb.append('2');
            helper(sb, n-2);
            sb.deleteCharAt(sb.length() -1);
        }

        if(n >= 3){
            sb.append('3');
            helper(sb, n-3);
            sb.deleteCharAt(sb.length() -1);
        }
    }
    public static void main(String args[]){
        int n = 3;
        printStair("", 3);
    }
}
