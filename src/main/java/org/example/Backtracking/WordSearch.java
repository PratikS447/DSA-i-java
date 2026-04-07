package org.example.Backtracking;

public class WordSearch {
    public static void main (String[] args) throws java.lang.Exception
    {
        //your code here
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word = "ABCB";
        boolean result = exist(board, word);
        System.out.println(result);
    }

    public static boolean exist(char board[][], String word){
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if(board[i][j] == word.charAt(0) && check(board, word, i, j, 0)){
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean check(char board[][], String word, int row, int col, int idx){
        if(idx == word.length()) return true;

        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length ||
                idx > word.length() || word.charAt(idx) != board[row][col]) return false;

        char temp = board[row][col];
        board[row][col] = '.';

        boolean res = check(board, word, row-1, col, idx+1) ||
                check(board, word, row+1, col, idx+1) ||
                check(board, word, row, col-1, idx+1) ||
                check(board, word, row, col+1, idx+1);

        board[row][col] = temp;

        return res;
    }
}
