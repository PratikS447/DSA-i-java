package org.example.TwoDArray;

public class AlternatMatrix {
    public static void altMatrix(int mat[][]){
        for (int i = 0; i < mat.length; i++){
            if(i % 2 == 0){
                for (int j = 0; j < mat[0].length; j++){
                    System.out.print(mat[i][j]+" ");
                }
            }else{
                for (int j = mat[0].length-1; j >= 0; j--){
                    System.out.print(mat[i][j]+" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String args[]){
        int mat[][] = {
                {7, 2, 3},
                {2, 3, 4},
                {5, 6, 1}

        };

        altMatrix(mat);
    }
}
