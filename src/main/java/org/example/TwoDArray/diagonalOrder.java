package org.example.TwoDArray;

import java.util.ArrayList;
import java.util.List;

public class diagonalOrder {
    public static List<Integer> upward(int mat[][]){
       int n = mat.length-1;
       int m = mat[0].length-1;
       List<Integer> ls = new ArrayList<>();
       for (int k = 0; k <= m+n+1; k++){
           int i = Math.min(k, n);
           int j = k -i;

           while(i >= 0 && j <= m){
               ls.add(mat[i][j]);
               i--;
               j++;
           }
       }
       return ls;
    }

    public static List<Integer> downward(int mat[][]){
        List<Integer> ls = new ArrayList<>();
        int n = mat.length; int m = mat[0].length;
        for (int k = n-1; k >= -(n-1); k--){
            for (int i = 0; i < n; i++){
                int j = i + k;
                if(j < m && j >= 0){
                    ls.add(mat[i][j]);
                }
            }
        }
        return ls;
    }

    public static boolean special_Matrix(int mat[][]){
        for(int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if ((i + j) % 2 == 0) {
                    if (mat[i][j] == 0) {
                        return false;
                    }
                } else {
                    if (mat[i][j] == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String args[]){
        int arr[][] = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 },
                { 17, 18, 19, 20 }
        };
        System.out.print(downward(arr));
    }
}
