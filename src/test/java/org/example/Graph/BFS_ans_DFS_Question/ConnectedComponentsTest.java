package org.example.Graph.BFS_ans_DFS_Question;

import org.example.Graph.BFS_AND_DFS_Question.Connected_Components_Problem_In_Matrix;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConnectedComponentsTest {

    private ArrayList<ArrayList<Integer>> buildEdges(int[]... pairs) {
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        for (int[] p : pairs) {
            edges.add(new ArrayList<>(Arrays.asList(p[0], p[1])));
        }
        return edges;
    }

    @Test
    void testSingleComponent() {
        // 0-1-2-3-4 all connected in a chain
        ArrayList<ArrayList<Integer>> edges = buildEdges(
                new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 4}
        );
        Connected_Components_Problem_In_Matrix sol = new Connected_Components_Problem_In_Matrix();
        assertEquals(1, sol.countConnected(5, edges));
    }

    @Test
    void testTwoDisjointComponents() {
        // {0,1,2} connected, {3,4} connected, separate
        ArrayList<ArrayList<Integer>> edges = buildEdges(
                new int[]{0, 1}, new int[]{1, 2}, new int[]{3, 4}
        );
        Connected_Components_Problem_In_Matrix sol = new Connected_Components_Problem_In_Matrix();
        assertEquals(2, sol.countConnected(5, edges));
    }

    @Test
    void testAllIsolatedVertices() {
        // No edges at all -> every vertex is its own component
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        Connected_Components_Problem_In_Matrix sol = new Connected_Components_Problem_In_Matrix();
        assertEquals(4, sol.countConnected(4, edges));
    }

    @Test
    void testSingleVertexNoEdges() {
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        Connected_Components_Problem_In_Matrix sol = new Connected_Components_Problem_In_Matrix();
        assertEquals(1, sol.countConnected(1, edges));
    }

    @Test
    void testCycleCountsAsOneComponent() {
        // 0-1-2-0 forms a cycle, still one component
        ArrayList<ArrayList<Integer>> edges = buildEdges(
                new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 0}
        );
        Connected_Components_Problem_In_Matrix sol = new Connected_Components_Problem_In_Matrix();
        assertEquals(1, sol.countConnected(3, edges));
    }

    @Test
    void testDisconnectedWithOneIsolatedVertex() {
        // {0,1} connected, 2 isolated, {3,4} connected
        ArrayList<ArrayList<Integer>> edges = buildEdges(
                new int[]{0, 1}, new int[]{3, 4}
        );
        Connected_Components_Problem_In_Matrix sol = new Connected_Components_Problem_In_Matrix();
        assertEquals(3, sol.countConnected(5, edges));
    }

    @Test
    void testSelfLoopDoesNotAffectComponentCount() {
        // Self-loop on 0, plus 1-2 connected, 3 isolated
        ArrayList<ArrayList<Integer>> edges = buildEdges(
                new int[]{0, 0}, new int[]{1, 2}
        );
        Connected_Components_Problem_In_Matrix sol = new Connected_Components_Problem_In_Matrix();
        assertEquals(3, sol.countConnected(4, edges));
    }

    @Test
    void testCompleteGraphIsOneComponent() {
        // Fully connected graph among 4 vertices
        ArrayList<ArrayList<Integer>> edges = buildEdges(
                new int[]{0, 1}, new int[]{0, 2}, new int[]{0, 3},
                new int[]{1, 2}, new int[]{1, 3}, new int[]{2, 3}
        );
        Connected_Components_Problem_In_Matrix sol = new Connected_Components_Problem_In_Matrix();
        assertEquals(1, sol.countConnected(4, edges));
    }

    @Test
    void testDuplicateEdgesDoNotCreateExtraComponents() {
        // Duplicate edge 0-1 shouldn't matter
        ArrayList<ArrayList<Integer>> edges = buildEdges(
                new int[]{0, 1}, new int[]{0, 1}, new int[]{2, 3}
        );
        Connected_Components_Problem_In_Matrix sol = new Connected_Components_Problem_In_Matrix();
        assertEquals(2, sol.countConnected(4, edges));
    }
}