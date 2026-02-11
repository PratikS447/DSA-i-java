package org.example.TwoDArray;

public class rotate90 {
    public static void transpose(int mat[][]){
        for(int i = 0; i < mat.length; i++){
            for (int j = i; j < mat[0].length; j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
    }

    public static void reverse(int mat[][]){
        int n = mat[0].length/2;
        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[0].length/2; j++){
                int temp = mat[i][j];
                mat[i][j] = mat[i][n-j-1];
                mat[i][n-j-1] = temp;
            }
        }
    }

    public static void rot90(int mat[][]){
        transpose(mat);
        reverse(mat);
    }

    public static void main(String args[]){
        int mat[][] = {
                {7, 2, 3},
                {2, 3, 4},
                {5, 6, 1}

        };

        rot90(mat);
        for(int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[0].length; j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
}
