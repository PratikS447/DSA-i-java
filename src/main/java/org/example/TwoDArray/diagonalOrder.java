package org.example.TwoDArray;

import java.util.ArrayList;

public class diagonalOrder {
    public static ArrayList<Integer> upward(int mat[][]){
        ArrayList<Integer> res = new ArrayList<>();

        int n = mat.length;
        int m = mat[0].length;

        for (int line = 1; line <= (n +m -1); line++){
            int startCol = Math.max(0, line -n);

            int count = Math.min(Math.min(line, m - startCol), n);

            for (int j = 0; j < count; j++){
                int row = Math.min(n, line) -j -1;
                int col = startCol + j;
                res.add(mat[row][col]);
            }
        }
        return res;
    }

    public static void downward(int mat[][]){

    }

    public static void main(String args[]){
        int arr[][] = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 },
                { 17, 18, 19, 20 }
        };
        System.out.print(upward(arr));
    }
}
