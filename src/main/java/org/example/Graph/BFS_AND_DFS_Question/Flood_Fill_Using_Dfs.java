package org.example.Graph.BFS_AND_DFS_Question;

import java.util.ArrayList;
import java.util.List;

public class Flood_Fill_Using_Dfs {
    public static int[][] flood_fill(int image[][], int sr, int sc, int color){
        int temp = image[sr][sc];
        if(temp == color){
            return image;
        }

        dfs(image, sr, sc, color, temp);

        return image;
    }

    private static int[] row = {-1, 0, 1, 0};
    private static int[] col = {0, 1, 0, -1};
    public static void dfs(int image[][], int sr, int sc, int color, int prev){
        int n = image.length;
        int m = image[0].length;
        image[sr][sc] = color;
        for (int d = 0; d < 4; d++){
            int nr = sr + row[d];
            int nc = sc + col[d];
            if(nr >= 0 && nr < n && nc >= 0 && nc < m && image[nr][nc] == prev){
                dfs(image, nr, nc, color, prev);
            }
        }
    }
}
