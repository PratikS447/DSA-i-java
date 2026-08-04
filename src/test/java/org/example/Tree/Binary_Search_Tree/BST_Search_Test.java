package org.example.Tree.Binary_Search_Tree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BST_Search_Test {
    private Node node(int val, Node left, Node right){
        Node n = new Node(val);
        n.left = left;
        n.right = right;
        return n;
    }

    private Node buildSampleTree(){
        return node(8,
                node(3,
                        node(1, null, null),
                        node(6, node(4, null, null), node(7, null, null))),
                node(10, null,
                        node(14, node(13, null, null), null)));
    }

    @Test
    @DisplayName("Search for root value should return true")
    void testFindRoot() {
        // Arrange
        Node root = buildSampleTree();

        // Act
        boolean result = BST_Search.find(root, 8);

        // Assert
        assertTrue(result, "Root value 8 exists in the tree, should return true");
    }

    @Test
    @DisplayName("Search for a value in the left subtree should return true")
    void testFindInLeftSubtree() {
        // Arrange
        Node root = buildSampleTree();

        // Act
        boolean result = BST_Search.find(root, 4);

        // Assert
        assertTrue(result, "Value 4 exists in the left subtree, should return true");
    }

    @Test
    @DisplayName("Search for a value in the right subtree should return true")
    void testFindInRightSubtree() {
        // Arrange
        Node root = buildSampleTree();

        // Act
        boolean result = BST_Search.find(root, 13);

        // Assert
        assertTrue(result, "Value 13 exists in the right subtree, should return true");
    }

    @Test
    @DisplayName("Search for a leaf node value should return true")
    void testFindLeafNode() {
        // Arrange
        Node root = buildSampleTree();

        // Act
        boolean result = BST_Search.find(root, 1);

        // Assert
        assertTrue(result, "Value 1 is a leaf node, should return true");
    }

    @Test
    @DisplayName("Search for a value not in the tree should return false")
    void testValueNotFound() {
        // Arrange
        Node root = buildSampleTree();

        // Act
        boolean result = BST_Search.find(root, 100);

        // Assert
        assertFalse(result, "Value 100 does not exist in the tree, should return false");
    }

    @Test
    @DisplayName("Search on empty tree (null root) should return false")
    void testEmptyTree() {
        // Arrange
        Node root = null;

        // Act
        boolean result = BST_Search.find(root, 5);

        // Assert
        assertFalse(result, "Searching an empty tree should always return false");
    }

    @Test
    @DisplayName("Search on single-node tree matching value should return true")
    void testSingleNodeTreeFound() {
        // Arrange
        Node root = node(42, null, null);

        // Act
        boolean result = BST_Search.find(root, 42);

        // Assert
        assertTrue(result, "Single node tree containing the searched value should return true");
    }

    @Test
    @DisplayName("Search on single-node tree with non-matching value should return false")
    void testSingleNodeTreeNotFound() {
        // Arrange
        Node root = node(42, null, null);

        // Act
        boolean result = BST_Search.find(root, 7);

        // Assert
        assertFalse(result, "Single node tree not containing the searched value should return false");
    }

    @Test
    @DisplayName("Search for value smaller than all nodes should return false")
    void testValueSmallerThanAll() {
        // Arrange
        Node root = buildSampleTree();

        // Act
        boolean result = BST_Search.find(root, -50);

        // Assert
        assertFalse(result, "Value smaller than every node in the tree should return false");
    }

    @Test
    @DisplayName("Search for value larger than all nodes should return false")
    void testValueLargerThanAll() {
        // Arrange
        Node root = buildSampleTree();

        // Act
        boolean result = BST_Search.find(root, 1000);

        // Assert
        assertFalse(result, "Value larger than every node in the tree should return false");
    }

    @Test
    @DisplayName("Search for Integer.MIN_VALUE present in tree should return true")
    void testFindIntegerMinValue() {
        // Arrange
        Node root = node(0,
                node(Integer.MIN_VALUE, null, null),
                node(1, null, null));

        // Act
        boolean result = BST_Search.find(root, Integer.MIN_VALUE);

        // Assert
        assertTrue(result, "Integer.MIN_VALUE stored as a node value should still be found correctly");
    }
}
