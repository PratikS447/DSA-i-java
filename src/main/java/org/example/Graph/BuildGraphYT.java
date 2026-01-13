package org.example.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BuildGraphYT {
    static class Edge{
        int src;
        int dest;
        Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }
    // QUESTION : CREATE THE GRAPH
    public static void buildGraph(List<Edge> graph[]){
        for (int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,5));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,2));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));
    }
    // QUESTION : PERFORM BFS TRAVERSAL
    public static void bfs(List<Edge> graph[]){
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[graph.length];

        q.add(0);
        while (!q.isEmpty()){
            int curr = q.remove();
            if (!vis[curr]){
                vis[curr] = true;
                System.out.print(curr+" ");
                for (int i = 0; i < graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    // QUESTION : PERFORM DFS TRAVERSAL
    public static void dfs(List<Edge> graph[], boolean vis[], int curr){
        System.out.print(curr+" ");
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]){
                dfs(graph, vis, e.dest);
            }
        }
    }

    // QUESTION : PRINT ALL POSSIBLE PATH TO THE TARGET VALUE
    public static void uniPath(List<Edge> graph[], boolean vis[], int curr, String path, int target){
        if (curr == target){
            System.out.println("Path : "+path);
            return;
        }

        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]){
                uniPath(graph, vis, e.dest, path+e.dest, target);
            }
        }
        vis[curr] = false;
    }

    // QUESTION : CREATE A GRAPH

    public static void main(String args[]){
        int Vertex = 7;
        List<Edge> graph[] = new ArrayList[Vertex];
        buildGraph(graph);
        System.out.print("Breath first search : ");
        bfs(graph);
        System.out.println();
        System.out.print("Dept first search : ");
        dfs(graph, new boolean[Vertex], 0);

        System.out.println();
        System.out.print("Unique Paths : ");
        boolean vis[] = new boolean[Vertex];
        vis[0] = true;
        uniPath(graph, vis, 0, "0", 5);
    }
}
