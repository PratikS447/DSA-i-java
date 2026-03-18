package org.example.Backtracking;

import java.util.Scanner;

public class MazePath_2 {
    public static void paths(int n, int m){
        helper(n, m, 1, 1, new StringBuilder(""));
    }
    public static void helper(int n, int m, int row, int col, StringBuilder sb){
        if(row == n && col == m){
            System.out.println(sb);
            return;
        }

        for(int k = 1; k + col  <= m; k++){
            sb.append("h"+k);
            helper(n, m, row, col+k, sb);
            sb.deleteCharAt(sb.length() -1);
            sb.deleteCharAt(sb.length() -1);
        }

        for(int k = 1; k + row <= n; k++){
            sb.append("v"+k);
            helper(n, m, row+k, col, sb);
            sb.deleteCharAt(sb.length() -1);
            sb.deleteCharAt(sb.length() -1);
        }

        for(int k = 1; k <= Math.min(n- row, m -col);  k++){
            sb.append("d"+k);
            helper(n, m, row+k, col+k, sb);
            sb.deleteCharAt(sb.length() -1);
            sb.deleteCharAt(sb.length() -1);
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        paths(n, m);
    }
}
