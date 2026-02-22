package org.example.TwoDArray;

import java.util.Arrays;

public class SortMatrixRowWise {
    public static void sortRow(int[][] mat, int N, int M){
        // Write your code and print here
        for(int i = 0; i < mat.length; i++){
            int res[] = new int[mat[0].length];
            for(int j = 0; j < mat[0].length; j++){
                res[j] = mat[i][j];
            }
            Arrays.sort(res);
            for(int j = 0; j < mat[0].length; j++){
                mat[i][j] = res[j];
            }
        }

        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]){
        int [][] mat = {{9, 7, 8, 11, 21},
                {1, 4, 3, 7, 2},
                {4,3, 14, 9, 12}};
        sortRow(mat, mat.length, mat[0].length);
    }
}
