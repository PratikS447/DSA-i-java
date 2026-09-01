package org.example.Graph.BFS_AND_DFS_Question;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Undirected_Graph_Cycle {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        for(int e[]: edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        boolean vis[] = new boolean[V];
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                if(bfs(i, adj, vis)) return true;
            }
        }
        return false;
    }

    public boolean bfs(int idx, List<List<Integer>> adj, boolean vis[]){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{idx, -1});
        vis[idx] = true;
        while(!queue.isEmpty()){
            int arr[] = queue.poll();
            int node = arr[0], parent = arr[1];
            for(int ele: adj.get(node)){
                if(!vis[ele]){
                    vis[ele] = true;
                    queue.offer(new int[]{ele, node});
                }else if(ele != parent){
                    return true;
                }
            }
        }

        return false;
    }
}
