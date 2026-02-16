package org.example.TwoDArray;

public class SumOfUpperAndLower {
    public static void triangleSum(int mat[][]){
        int sum = 0;
        int sum2 = 0;
        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[0].length; j++){
                if(i >= j){
                    sum = sum + mat[i][j];
                }
                if(j >= i){
                    sum2 = sum2 + mat[i][j];
                }
            }
        }
        System.out.print(sum +" "+sum2);
    }

    public static void main(String args[]){
        int mat[][] = {{1, 2, 3},
                {1, 5, 3},
                {4, 5, 6}};
        triangleSum(mat);
    }
}
