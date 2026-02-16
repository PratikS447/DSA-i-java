package org.example.TwoDArray;

public class SpiralMatrix {
    public static void sprialTraversal(int mat[][]){
        int row = 0;
        int col = 0;
        int rowEnd = mat.length-1;
        int colEnd = mat[0].length-1;

        while(row <= rowEnd && col <= colEnd){
            boundaryTraversal(row, col, rowEnd, colEnd, mat);
            row++; col++;
            rowEnd--; colEnd--;
        }

    }
    public static void boundaryTraversal(int row, int col, int rowEnd, int colEnd, int mat[][]){
        if(row == rowEnd){
            for(int j = col; j <= colEnd; j++){
                System.out.print(mat[row][j]+" ");
            }
            return;
        }

        if(col == colEnd){
            for (int i = row; i <= rowEnd; i++){
                System.out.print(mat[i][col]+" ");
            }
            return;
        }

        // go right
        for(int j = col; j <= colEnd; j++){
            System.out.print(mat[row][j]+" ");
        }

        // go down
        for (int i = row+1; i <= rowEnd; i++){
            System.out.print(mat[i][colEnd]+" ");
        }

        // go right
        for (int j = colEnd-1; j >= col; j--){
            System.out.print(mat[rowEnd][j]+" ");
        }

        // go up
        for (int i = rowEnd -1; i >= row+1; i--){
            System.out.print(mat[i][col]+" ");
        }
    }

    public static void main(String args[]){
        int mat[][] = {{1, 2, 3}};
        sprialTraversal(mat);
    }
}
