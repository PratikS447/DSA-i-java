package org.example.Tree.Binary_Search_Tree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Valid_BST_Test {

    private Node node(int val, Node left, Node right){
        Node n = new Node(val);
        n.left = left;
        n.right = right;
        return n;
    }

    @Test
    @DisplayName("Valid BST with multiple levels should return true")
    void testValidBST(){
       Node root = node(5,
               node(3, node(1, null, null), node(4, null, null)),
               node(8, null, node(10, null, null)));

       boolean result = Valid_BST.isValid(root);
       assertTrue(result, "Tree follows BST Property");
    }

    @Test
    @DisplayName("Invalid BST - immediate parent-child violation should return false")
    void testInvalidBST_ImmediateViolation() {
        // Arrange
        //     5
        //    / \
        //   1   4   <- 4 is less than root 5, violates BST rule
        Node root = node(5,
                node(1, null, null),
                node(4, null, null));

        // Act
        boolean result = Valid_BST.isValid(root);

        // Assert
        assertFalse(result, "Right child (4) is less than root (5), should return false");
    }

    @Test
    @DisplayName("Invalid BST - ancestor violation (not caught by parent-only check)")
    void testInvalidBST_AncestorViolation() {
        // Arrange
        //            8
        //          /   \
        //         3     10
        //        / \      \
        //       1   6     14
        //          / \     /
        //         4  12  13   <- 12 violates root's (8) upper bound, though > its parent (6)
        Node root = node(8,
                node(3,
                        node(1, null, null),
                        node(6, node(4, null, null), node(12, null, null))),
                node(10, null,
                        node(14, node(13, null, null), null)));

        // Act
        boolean result = Valid_BST.isValid(root);

        // Assert
        assertFalse(result, "Node 12 violates ancestor (8)'s upper bound, should return false");
    }

    @Test
    @DisplayName("Single node tree should return true")
    void testSingleNode() {
        // Arrange
        Node root = node(1, null, null);

        // Act
        boolean result = Valid_BST.isValid(root);

        // Assert
        assertTrue(result, "A single node tree is always a valid BST");
    }

    @Test
    @DisplayName("Null root should return true")
    void testNullRoot() {
        // Arrange
        Node root = null;

        // Act
        boolean result = Valid_BST.isValid(root);

        // Assert
        assertTrue(result, "An empty tree is considered a valid BST");
    }

    @Test
    @DisplayName("Duplicate values should return false (strict inequality required)")
    void testDuplicateValues() {
        // Arrange
        //     2
        //    / \
        //   2   3   <- left child equals root, violates strict BST rule
        Node root = node(2,
                node(2, null, null),
                node(3, null, null));

        // Act
        boolean result = Valid_BST.isValid(root);

        // Assert
        assertFalse(result, "Duplicate values are not allowed in a strict BST "
                + "(requires the <= fix mentioned above; currently fails with plain <)");
    }

    @Test
    @DisplayName("Tree containing Integer.MIN_VALUE should be handled correctly")
    void testIntegerMinValueNode() {
        // Arrange
        //         0
        //        / \
        //   MIN_VALUE  1
        Node root = node(0,
                node(Integer.MIN_VALUE, null, null),
                node(1, null, null));

        // Act
        boolean result = Valid_BST.isValid(root);

        // Assert
        assertTrue(result, "Tree containing Integer.MIN_VALUE as a valid leaf should still return true");
    }

    @Test
    @DisplayName("Left-skewed strictly decreasing tree is a valid BST")
    void testLeftSkewedTree() {
        // Arrange
        //         5
        //        /
        //       4
        //      /
        //     3
        //    /
        //   2
        Node root = node(5,
                node(4,
                        node(3,
                                node(2, null, null), null),
                        null),
                null);

        // Act
        boolean result = Valid_BST.isValid(root);

        // Assert
        assertTrue(result, "Strictly decreasing left-skewed tree is a valid BST");
    }

    @Test
    @DisplayName("Right-skewed strictly increasing tree is a valid BST")
    void testRightSkewedTree() {
        // Arrange
        //   2
        //    \
        //     3
        //      \
        //       4
        //        \
        //         5
        Node root = node(2, null,
                node(3, null,
                        node(4, null,
                                node(5, null, null))));

        // Act
        boolean result = Valid_BST.isValid(root);

        // Assert
        assertTrue(result, "Strictly increasing right-skewed tree is a valid BST");
    }
}
