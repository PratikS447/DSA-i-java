package org.example.Graph.BFS_ans_DFS_Question;

import org.example.Graph.BFS_AND_DFS_Question.Undirected_Graph_Cycle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UndirectedGraphCycleTest {

    @Test
    void testNoEdgesNoCycle() {
        int[][] edges = {};
        Undirected_Graph_Cycle sol = new Undirected_Graph_Cycle();
        assertFalse(sol.isCycle(4, edges));
    }

    @Test
    void testSingleVertexNoEdges() {
        int[][] edges = {};
        Undirected_Graph_Cycle sol = new Undirected_Graph_Cycle();
        assertFalse(sol.isCycle(1, edges));
    }

    @Test
    void testLinearChainNoCycle() {
        // 0-1-2-3, a simple path, no cycle
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}};
        Undirected_Graph_Cycle sol = new Undirected_Graph_Cycle();
        assertFalse(sol.isCycle(4, edges));
    }

    @Test
    void testTreeStructureNoCycle() {
        // 0 is root, 1 and 2 are children, 3 and 4 are children of 1
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {1, 4}};
        Undirected_Graph_Cycle sol = new Undirected_Graph_Cycle();
        assertFalse(sol.isCycle(5, edges));
    }

    @Test
    void testSimpleTriangleCycle() {
        // 0-1-2-0 forms a cycle
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}};
        Undirected_Graph_Cycle sol = new Undirected_Graph_Cycle();
        assertTrue(sol.isCycle(3, edges));
    }

    @Test
    void testCycleInLargerGraph() {
        // 0-1-2-3-4-0 forms a cycle among 5 vertices
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 0}};
        Undirected_Graph_Cycle sol = new Undirected_Graph_Cycle();
        assertTrue(sol.isCycle(5, edges));
    }

    @Test
    void testDisconnectedGraphWithCycleInOneComponent() {
        // {0,1} is a plain edge, {2,3,4} forms a cycle
        int[][] edges = {{0, 1}, {2, 3}, {3, 4}, {4, 2}};
        Undirected_Graph_Cycle sol = new Undirected_Graph_Cycle();
        assertTrue(sol.isCycle(5, edges));
    }

    @Test
    void testDisconnectedGraphNoCycleAnywhere() {
        // {0,1} separate from {2,3,4} chain, neither has a cycle
        int[][] edges = {{0, 1}, {2, 3}, {3, 4}};
        Undirected_Graph_Cycle sol = new Undirected_Graph_Cycle();
        assertFalse(sol.isCycle(5, edges));
    }

    @Test
    void testMultiEdgeBetweenSamePairIsCycle() {
        // Two edges between 0 and 1 form a 2-cycle in a multigraph
        int[][] edges = {{0, 1}, {0, 1}};
        Undirected_Graph_Cycle sol = new Undirected_Graph_Cycle();
        assertTrue(sol.isCycle(2, edges));
    }

    @Test
    void testAllIsolatedVerticesNoCycle() {
        int[][] edges = {};
        Undirected_Graph_Cycle sol = new Undirected_Graph_Cycle();
        assertFalse(sol.isCycle(6, edges));
    }
}