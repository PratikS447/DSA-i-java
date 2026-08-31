package org.example.Graph.BFS_AND_DFS_Question;

import java.util.LinkedList;
import java.util.Queue;

public class Rotten_Oranges {
    public int orangesRot(int[][] mat) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        Queue<int[]> queue = new LinkedList<>(); // stores row and col

        int fresh_oranges = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 2){
                    queue.add(new int[]{i, j});
                }else if(mat[i][j] == 1){
                    fresh_oranges++;
                }
            }
        }

        if(fresh_oranges == 0){
            return 0;
        }

        int ans = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int node[] = queue.poll();
                int row = node[0], col = node[1];
                if(row -1 >= 0 && mat[row-1][col] == 1){
                    mat[row-1][col] = 2;
                    queue.add(new int[]{row-1, col});
                }
                if(col +1 < m && mat[row][col+1] == 1){
                    mat[row][col+1] = 2;
                    queue.add(new int[]{row, col+1});
                }
                if(row +1 < n && mat[row+1][col] == 1){
                    mat[row+1][col] = 2;
                    queue.add(new int[]{row+1, col});
                }
                if(col -1 >= 0 && mat[row][col-1] == 1){
                    mat[row][col-1] = 2;
                    queue.add(new int[]{row, col-1});
                }
            }
            ans++;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 1){
                    return -1;
                }
            }
        }

        return ans-1;
    }
}
