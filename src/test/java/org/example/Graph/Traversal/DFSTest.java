package org.example.Graph.Traversal;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DFSTest {

    // Helper to build an adjacency list from edge pairs (undirected)
    private ArrayList<ArrayList<Integer>> buildGraph(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        return adj;
    }

    @Test
    void singleNodeNoEdges() {
        ArrayList<ArrayList<Integer>> adj = buildGraph(1, new int[][]{});
        List<Integer> result = DFS.traverse(adj);
        assertEquals(List.of(0), result);
    }

    @Test
    void emptyGraph() {
        ArrayList<ArrayList<Integer>> adj = buildGraph(0, new int[][]{});
        List<Integer> result = DFS.traverse(adj);
        assertTrue(result.isEmpty());
    }

    @Test
    void linearChain() {
        // 0 - 1 - 2 - 3
        ArrayList<ArrayList<Integer>> adj = buildGraph(4, new int[][]{{0,1},{1,2},{2,3}});
        List<Integer> result = DFS.traverse(adj);
        assertEquals(List.of(0, 1, 2, 3), result);
    }

    @Test
    void branchingTree() {
        //     0
        //    / \
        //   1   2
        //  /
        // 3
        ArrayList<ArrayList<Integer>> adj = buildGraph(4, new int[][]{{0,1},{0,2},{1,3}});
        List<Integer> result = DFS.traverse(adj);
        // DFS goes deep on 1 before backtracking to 2
        assertEquals(List.of(0, 1, 3, 2), result);
    }

    @Test
    void disconnectedComponents() {
        // Component A: 0-1   Component B: 2-3
        ArrayList<ArrayList<Integer>> adj = buildGraph(4, new int[][]{{0,1},{2,3}});
        List<Integer> result = DFS.traverse(adj);
        // Outer loop ensures every component gets visited, starting from lowest unvisited index
        assertEquals(List.of(0, 1, 2, 3), result);
    }

    @Test
    void graphWithCycleDoesNotInfiniteLoop() {
        // Triangle: 0-1-2-0
        ArrayList<ArrayList<Integer>> adj = buildGraph(3, new int[][]{{0,1},{1,2},{0,2}});
        List<Integer> result = DFS.traverse(adj);
        assertEquals(3, result.size());
        assertTrue(result.containsAll(List.of(0, 1, 2)));
    }

    @Test
    void allNodesVisitedExactlyOnce() {
        ArrayList<ArrayList<Integer>> adj = buildGraph(5,
                new int[][]{{0,1},{1,2},{2,3},{3,4},{4,0}}); // 5-cycle
        List<Integer> result = DFS.traverse(adj);
        assertEquals(5, result.size());
        assertEquals(5, result.stream().distinct().count()); // no duplicates
    }

    @Test
    void isolatedVertexAmongConnectedOnes() {
        // 0-1 connected, 2 isolated
        ArrayList<ArrayList<Integer>> adj = buildGraph(3, new int[][]{{0,1}});
        List<Integer> result = DFS.traverse(adj);
        assertEquals(List.of(0, 1, 2), result);
    }
}