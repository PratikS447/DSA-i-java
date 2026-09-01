package org.example.Graph.BFS_AND_DFS_Question;

import java.util.ArrayList;

public class Connected_Components_Problem_In_Matrix {
    public int countConnected(int V, ArrayList<ArrayList<Integer>> edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < edges.size(); i++){
            int u = edges.get(i).get(0); 
            int v = edges.get(i).get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        int cnt = 0;
        boolean vis[] = new boolean[V];
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                dfs(V, adj, vis, i);
                cnt++;
            }
        }
        return cnt;
    }
    
    void dfs(int V, ArrayList<ArrayList<Integer>> adj, 
    boolean vis[], int i){
        vis[i] = true;
        for(int ele: adj.get(i)){
            if(!vis[ele]){
                dfs(V, adj, vis, ele);
            }
        }
    }
}