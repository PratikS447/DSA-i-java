package org.example.Backtracking;

import java.util.Scanner;

public class MazePath {
    public static void paths(int rows, int cols){
        StringBuilder ans = new StringBuilder("");
        helper(rows, cols, ans, 0, 0);
    }
    public static void helper(int n, int m, StringBuilder sb, int i, int j){
        if(i == n-1 && j == m-1){
            System.out.println(sb);
            return;
        }
        if(j < n){
            sb.append('h');
            helper(n, m, sb, i, j+1);
            sb.deleteCharAt(sb.length() -1);
        }
        if(i < m){
            sb.append('v');
            helper(n, m, sb, i+1, j);
            sb.deleteCharAt(sb.length() -1);
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        paths(num1, num2);
    }
}
