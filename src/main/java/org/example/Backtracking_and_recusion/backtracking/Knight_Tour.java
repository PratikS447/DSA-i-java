package org.example.Backtracking_and_recusion.backtracking;

import java.util.ArrayList;

public class Knight_Tour {
    public ArrayList<ArrayList<Integer>> tour(int n) {
        // code here
        int mat[][] = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                mat[i][j] = -1;
            }
        }

        mat[0][0] = 0;
        boolean found = helper(n, mat, 0, 0, 1);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(found){
            for(int i = 0; i < n; i++){
                ArrayList<Integer> ls = new ArrayList<>();
                for(int j = 0; j < n; j++){
                    ls.add(mat[i][j]);
                }
                ans.add(ls);
            }
        }
        return ans;
    }

    public boolean helper(int n, int mat[][], int row, int col, int idx){
        if((n*n) == idx){
            return true;
        }

        // 1
        if(row -2 >= 0 && col + 1 < mat[0].length && mat[row-2][col+1] == -1){
            mat[row-2][col+1] = idx;
            if(helper(n, mat, row-2, col+1, idx+1)) return true;
            mat[row-2][col+1] = -1;
        }

        // 2
        if(row -1 >= 0 && col + 2 < mat[0].length && mat[row-1][col+2] == -1){
            mat[row-1][col+2] = idx;
            if(helper(n, mat, row-1, col+2, idx+1)) return true;
            mat[row-1][col+2] = -1;
        }

        // 3
        if(row +1 < mat.length && col + 2 < mat[0].length && mat[row+1][col+2] == -1){
            mat[row+1][col+2] = idx;
            if(helper(n, mat, row+1, col+2, idx+1)) return true;
            mat[row+1][col+2] = -1;
        }

        // 4
        if(row +2 < mat.length && col + 1 < mat[0].length && mat[row+2][col+1] == -1){
            mat[row+2][col+1] = idx;
            if(helper(n, mat, row+2, col+1, idx+1)) return true;
            mat[row+2][col+1] = -1;
        }

        // 5
        if(row +2 < mat.length && col -1 >= 0 && mat[row+2][col-1] == -1){
            mat[row+2][col-1] = idx;
            if(helper(n, mat, row+2, col-1, idx+1)) return true;
            mat[row+2][col-1] = -1;
        }

        // 6
        if(row +1 < mat.length && col -2 >= 0 && mat[row+1][col-2] == -1){
            mat[row+1][col-2] = idx;
            if(helper(n, mat, row+1, col-2, idx+1)) return true;
            mat[row+1][col-2] = -1;
        }

        // 7
        if(row -1 >= 0 && col -2 >= 0 && mat[row-1][col-2] == -1){
            mat[row-1][col-2] = idx;
            if(helper(n, mat, row-1, col-2, idx+1)) return true;
            mat[row-1][col-2] = -1;
        }

        // 8
        if(row -2 >= 0 && col -1 >= 0 && mat[row-2][col-1] == -1){
            mat[row-2][col-1] = idx;
            if(helper(n, mat, row-2, col-1, idx+1)) return true;
            mat[row-2][col-1] = -1;
        }

        return false;
    }
}
