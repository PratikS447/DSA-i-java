package org.example.Tree.Binary_Tree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerticalOrderTraversalTest {

    private final Vertical_Order_Traversal solution = new Vertical_Order_Traversal();

    // Helper to build a Node quickly
    private Node node(int val, Node left, Node right) {
        Node n = new Node(val);
        n.left = left;
        n.right = right;
        return n;
    }

    private Node node(int val) {
        return new Node(val);
    }

    @Test
    @DisplayName("Null root returns empty list")
    void nullRoot_returnsEmptyList() {
        // Arrange
        Node root = null;

        // Act
        List<List<Integer>> result = solution.verticalTraversal(root);

        // Assert
        assertEquals(List.of(), result);
    }

    @Test
    @DisplayName("Single node returns one column with one value")
    void singleNode_returnsSingleColumn() {
        // Arrange
        Node root = node(1);

        // Act
        List<List<Integer>> result = solution.verticalTraversal(root);

        // Assert
        assertEquals(List.of(List.of(1)), result);
    }

    @Test
    @DisplayName("Simple balanced tree, no column collisions")
    void balancedTree_noCollisions() {
        // Arrange: root=1, left=2, right=3
        //        1
        //      /   \
        //     2     3
        Node root = node(1, node(2), node(3));

        // Act
        List<List<Integer>> result = solution.verticalTraversal(root);

        // Assert: col -1 -> [2], col 0 -> [1], col 1 -> [3]
        assertEquals(Arrays.asList(
                List.of(2),
                List.of(1),
                List.of(3)
        ), result);
    }

    @Test
    @DisplayName("Same row+col collision resolved with values sorted ascending")
    void sameRowAndCol_tieBrokenByValue() {
        // Arrange:
        //        1
        //      /   \
        //     2     3
        //      \   /
        //       4 5
        // col 0: row0 -> 1 ; row2 -> 4 and 5 collide, expect sorted [4,5]
        Node left = node(2, null, node(4));
        Node right = node(3, node(5), null);
        Node root = node(1, left, right);

        // Act
        List<List<Integer>> result = solution.verticalTraversal(root);

        // Assert: col -1 -> [2], col 0 -> [1,4,5], col 1 -> [3]
        assertEquals(Arrays.asList(
                List.of(2),
                List.of(1, 4, 5),
                List.of(3)
        ), result);
    }

    @Test
    @DisplayName("Left-skewed tree produces one node per column")
    void leftSkewedTree_onePerColumn() {
        // Arrange
        //         1
        //        /
        //       2
        //      /
        //     3
        Node root = node(1, node(2, node(3), null), null);

        // Act
        List<List<Integer>> result = solution.verticalTraversal(root);

        // Assert: col -2 -> [3], col -1 -> [2], col 0 -> [1]
        assertEquals(Arrays.asList(
                List.of(3),
                List.of(2),
                List.of(1)
        ), result);
    }

    @Test
    @DisplayName("Right-skewed tree produces one node per column")
    void rightSkewedTree_onePerColumn() {
        // Arrange
        //   1
        //    \
        //     2
        //      \
        //       3
        Node root = node(1, null, node(2, null, node(3)));

        // Act
        List<List<Integer>> result = solution.verticalTraversal(root);

        // Assert: col 0 -> [1], col 1 -> [2], col 2 -> [3]
        assertEquals(Arrays.asList(
                List.of(1),
                List.of(2),
                List.of(3)
        ), result);
    }
}