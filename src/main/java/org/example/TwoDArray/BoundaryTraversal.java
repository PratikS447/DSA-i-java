package org.example.TwoDArray;

public class BoundaryTraversal {
    public static void traversal(int mat[][]){
        int n = mat.length;
        int m = mat[0].length;
        for(int j = 0; j < m; j++){
            System.out.print(mat[0][j]+" ");
        }
        for(int i = 1; i < n; i++){
            System.out.print(mat[i][n-1]+" ");
        }
        for(int j = m-2; j >= 0; j--){
            System.out.print(mat[n-1][j]+" ");
        }
        for(int i = n-2; i >= 1; i--){
            System.out.print(mat[i][0]+" ");
        }
    }

    public static void main(String args[]){
        int mat[][] = {{1, 2, 3},{4, 5, 6}, {7, 8, 9}};
        traversal(mat);
    }
}
