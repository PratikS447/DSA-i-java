package org.example.Graph.Traversal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BFSTraversalTest {

    private List<List<Integer>> buildGraph(int[][] edges, int n) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]); // undirected
        }
        return adj;
    }

    @Test
    @DisplayName("Simple connected graph visits all nodes in level order")
    void testSimpleConnectedGraph() {
        // Arrange: 0-1, 0-2, 1-3, 2-3  (square)
        List<List<Integer>> adj = buildGraph(new int[][]{{0,1},{0,2},{1,3},{2,3}}, 4);

        // Act
        List<Integer> result = BFS_Traversal.bfs(adj);

        // Assert
        assertEquals(Arrays.asList(0, 1, 2, 3), result);
    }

    @Test
    @DisplayName("Single node graph returns just that node")
    void testSingleNode() {
        // Arrange
        List<List<Integer>> adj = buildGraph(new int[][]{}, 1);

        // Act
        List<Integer> result = BFS_Traversal.bfs(adj);

        // Assert
        assertEquals(List.of(0), result);
    }

    @Test
    @DisplayName("Linear chain graph visits nodes in order 0 to n-1")
    void testLinearChain() {
        // Arrange: 0-1-2-3-4
        List<List<Integer>> adj = buildGraph(new int[][]{{0,1},{1,2},{2,3},{3,4}}, 5);

        // Act
        List<Integer> result = BFS_Traversal.bfs(adj);

        // Assert
        assertEquals(Arrays.asList(0, 1, 2, 3, 4), result);
    }

    @Test
    @DisplayName("Graph with an edge back to node 0 should not revisit node 0")
    void testCycleBackToStartExposesUnmarkedStartBug() {
        // Arrange: 0-1, 1-2  (triangle-ish: 0's neighbor list is [1], 1's is [0,2])
        List<List<Integer>> adj = buildGraph(new int[][]{{0,1},{1,2}}, 3);

        // Act
        List<Integer> result = BFS_Traversal.bfs(adj);

        // Assert: node 0 should appear exactly once
        long zeroCount = result.stream().filter(x -> x == 0).count();
        assertEquals(1, zeroCount, "Node 0 was revisited — vis[0] was never set true before the loop");
        assertEquals(Arrays.asList(0, 1, 2), result);
    }

    @Test
    @DisplayName("Disconnected graph only visits the component containing node 0")
    void testDisconnectedGraph() {
        // Arrange: 0-1 connected; 2-3 separate component
        List<List<Integer>> adj = buildGraph(new int[][]{{0,1},{2,3}}, 4);

        // Act
        List<Integer> result = BFS_Traversal.bfs(adj);

        // Assert: only 0 and 1 are reachable
        assertEquals(Arrays.asList(0, 1), result);
    }

    @Test
    @DisplayName("Star graph visits center then all leaves")
    void testStarGraph() {
        // Arrange: 0 connected to 1,2,3,4
        List<List<Integer>> adj = buildGraph(new int[][]{{0,1},{0,2},{0,3},{0,4}}, 5);

        // Act
        List<Integer> result = BFS_Traversal.bfs(adj);

        // Assert
        assertEquals(Arrays.asList(0, 1, 2, 3, 4), result);
    }
}