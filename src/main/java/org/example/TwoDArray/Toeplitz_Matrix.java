package org.example.TwoDArray;

public class Toeplitz_Matrix {
    public static boolean toeplitz_Matix(int matrix[][]){
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(matrix[i][j] != matrix[i-1][j-1]){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String args[]){
        int matrix[][] = {{3, 7, 3},
                {5, 3, 7}};
        System.out.println(toeplitz_Matix(matrix));

    }
}
