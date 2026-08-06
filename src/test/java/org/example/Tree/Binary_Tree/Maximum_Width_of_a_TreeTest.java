package org.example.Tree.Binary_Tree;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Maximum_Width_of_a_TreeTest {

    // ---------- Test 1: Single node ----------
    @Test
    void testSingleNode() {
        // Arrange
        //        1
        Node root = new Node(1);

        // Act
        int result = Maximum_Width_of_a_Tree.max_width(root);

        // Assert
        assertEquals(1, result, "A single node tree should have width 1");
    }

    // ---------- Test 2: Perfect complete binary tree ----------
    @Test
    void testPerfectCompleteTree() {
        // Arrange
        //        1
        //       / \
        //      2   3
        //     / \  / \
        //    4  5 6   7
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Act
        int result = Maximum_Width_of_a_Tree.max_width(root);

        // Assert
        assertEquals(4, result, "Last level is full, so width should be 4");
    }

    // ---------- Test 3: Left-skewed tree ----------
    @Test
    void testLeftSkewedTree() {
        // Arrange
        //        1
        //       /
        //      2
        //     /
        //    3
        //   /
        //  4
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.left.left = new Node(4);

        // Act
        int result = Maximum_Width_of_a_Tree.max_width(root);

        // Assert
        assertEquals(1, result, "A skewed tree has only one node per level, so width should be 1");
    }

    // ---------- Test 4: Right-skewed tree ----------
    @Test
    void testRightSkewedTree() {
        // Arrange
        //  1
        //   \
        //    2
        //     \
        //      3
        Node root = new Node(1);
        root.right = new Node(2);
        root.right.right = new Node(3);

        // Act
        int result = Maximum_Width_of_a_Tree.max_width(root);

        // Assert
        assertEquals(1, result, "A right-skewed tree has only one node per level, so width should be 1");
    }

    // ---------- Test 5: Classic LeetCode case with gaps (nulls in between) ----------
    @Test
    void testTreeWithGaps() {
        // Arrange
        //           1
        //          / \
        //         3   2
        //        /     \
        //       5       9
        //      /         \
        //     6           7
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);
        root.left.left = new Node(5);
        root.right.right = new Node(9);
        root.left.left.left = new Node(6);
        root.right.right.right = new Node(7);

        // Act
        int result = Maximum_Width_of_a_Tree.max_width(root);

        // Assert
        assertEquals(8, result, "Deepest level spans index 0 to 7, so width should be 8 even with gaps");
    }

    // ---------- Test 7: Only left children at one level (tests boundary trimming) ----------
    @Test
    void testOnlyLeftChildrenAtLastLevel() {
        // Arrange
        //        1
        //       / \
        //      2   3
        //     /
        //    4
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);

        // Act
        int result = Maximum_Width_of_a_Tree.max_width(root);

        // Assert
        assertEquals(2, result, "Level 1 (2 and 3) has width 2, which is the max across all levels");
    }

    // ---------- Test 8: Two levels, second level has only one node far right ----------
    @Test
    void testSparseSecondLevel() {
        // Arrange
        //        1
        //       / \
        //      2   3
        //           \
        //            4
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.right = new Node(4);

        // Act
        int result = Maximum_Width_of_a_Tree.max_width(root);

        // Assert
        assertEquals(2, result, "Level 1 has width 2 (2 and 3), level 2 has width 1 (only node 4)");
    }
}