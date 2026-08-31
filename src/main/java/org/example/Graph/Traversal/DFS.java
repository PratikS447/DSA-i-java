package org.example.Graph.Traversal;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    public static List<Integer> traverse(ArrayList<ArrayList<Integer>> adj){
        boolean vis[] = new boolean[adj.size()];
        int n = vis.length;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                dfs(i, ans, vis, adj);
            }
        }
        return ans;
    }

    public static void dfs(int idx, ArrayList<Integer> ans, boolean vis[],
                    ArrayList<ArrayList<Integer>> adj){
        vis[idx] = true;
        ans.add(idx);

        for(int a: adj.get(idx)){
            if(!vis[a]){
                dfs(a, ans, vis, adj);
            }
        }
    }
}
