package org.example.Backtracking_and_recusion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static List<List<String>> solveNQueens(int n){
        char mat[][] = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                mat[i][j] = '.';
            }
        }
        List<List<String>> ans = new ArrayList<>();
        queensHelper(mat, ans, 0);
        return ans;
    }

    public static void queensHelper(char mat[][],
                                    List<List<String>> ans, int row){
        if(mat.length == row){
            ans.add(reconstruct(mat));
            return;
        }
        for(int col = 0; col < mat.length; col++){
            if(check(mat, row, col)){
                mat[row][col] = 'Q';
                queensHelper(mat, ans, row+1);
                mat[row][col] = '.';
            }
        }
    }
    public static List<String> reconstruct(char mat[][]){
        List<String> res = new ArrayList<>();
        for(int i = 0; i < mat[0].length; i++){
            res.add(new String(mat[i]));
        }
        return res;
    }

    public static boolean check(char mat[][], int row, int col){
        // row check
        for(int j = col-1; j >= 0; j--){
            if(mat[row][j] == 'Q') return false;
        }

        // left diagonal
        for(int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--){
            if(mat[i][j] == 'Q') return false;
        }

        // col check
        for(int i = row-1; i >= 0; i--){
            if(mat[i][col] == 'Q') return false;
        }

        // right diagonal
        for(int i = row-1, j = col+1; i >= 0 && j < mat[0].length; i--, j++){
            if(mat[i][j] == 'Q') return false;
        }

        return true;
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        //your code here
        int n = 4;

        List<List<String>> result = solveNQueens(n);
        System.out.println(result);
        // for (List<String> board : result) {
        // 	for (String row : board) {
        // 		System.out.println(row);
        // 	}
        // 	System.out.println(); // separate solutions
        // }
    }
}
