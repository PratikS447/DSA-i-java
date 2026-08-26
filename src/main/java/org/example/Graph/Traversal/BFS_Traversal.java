package org.example.Graph.Traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS_Traversal {
    public static List<Integer> bfs(List<List<Integer>> adj){
        int n = adj.size();
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean vis[] = new boolean[n];
        queue.add(0);
        vis[0] = true;
        while (!queue.isEmpty()){
            int node = queue.poll();
            ans.add(node);
            for (int ele: adj.get(node)){
                if (!vis[ele]){
                    queue.offer(ele);
                    vis[ele] = true;
                }
            }
        }
        return ans;
    }
}
