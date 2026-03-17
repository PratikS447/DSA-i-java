package org.example.TwoDArray;

public class ValidSudoku {
    public static boolean valid_sudoku(char mat[][]){
        return checkRow(mat) && checkCol(mat) && checkGrid(mat);
    }

    public static boolean checkRow(char mat[][]){
        for(int row = 0; row < 9; row++){
            boolean[] check = new boolean[9];
            for(int col = 0; col < 9; col++){
                if(mat[row][col] == '.') continue;
                int curr = mat[row][col] - '1';
                if(check[curr]) return false;
                check[curr] = true;
            }
        }
        return true;
    }

    public static boolean checkGrid(char mat[][]){
        for(int row = 1; row < 9; row = row +3){
            for(int col = 1; col < 9; col = col + 3){
                if(!isValid(mat, row, col)) return false;
            }
        }
        return true;
    }

    public static boolean isValid(char mat[][], int row, int col){
        int directions[] = {-1, 0, 1};
        boolean isPresentOrNot[] = new boolean[9];
        for(int x : directions){
            for(int y : directions){
                int i = row + x;
                int j = col + y;
                if(mat[i][j] == '.') continue;
                int value = mat[i][j] - '1';
                if(isPresentOrNot[value]) return false;
                isPresentOrNot[value] = true;
            }
        }
        return true;
    }

    public static boolean checkCol(char mat[][]){
        for(int col = 0; col < 9; col++){
            boolean[] check = new boolean[9];
            for(int row = 0; row < 9; row++){
                if(mat[row][col] == '.') continue;
                int curr = mat[row][col] - '1';
                if(check[curr]) return false;
                check[curr] = true;
            }
        }
        return true;
    }
    public static void main(String args[]){
        char mat[][] = {{'5','3','5','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        System.out.println(valid_sudoku(mat));
    }
}
