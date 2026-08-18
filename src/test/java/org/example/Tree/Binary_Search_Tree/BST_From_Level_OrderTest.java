package org.example.Tree.Binary_Search_Tree;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;

class BST_From_Level_OrderTest {

    // helper to quickly build a Node with given children (mirrors preferred pattern)
    private Node node(int val, Node left, Node right) {
        Node n = new Node(val);
        n.left = left;
        n.right = right;
        return n;
    }

    // helper to get inorder traversal as a list (should always be sorted for a valid BST)
    private List<Integer> inorder(Node root) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }

    private void inorderHelper(Node root, List<Integer> result) {
        if (root == null) return;
        inorderHelper(root.left, result);
        result.add(root.data);
        inorderHelper(root.right, result);
    }

    // helper to get preorder traversal as a list (used to verify exact tree shape)
    private List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        preorderHelper(root, result);
        return result;
    }

    private void preorderHelper(Node root, List<Integer> result) {
        if (root == null) return;
        result.add(root.data);
        preorderHelper(root.left, result);
        preorderHelper(root.right, result);
    }

    @Test
    void testGivenExampleOne() {
        // Arrange
        int[] arr = {7, 4, 12, 3, 6, 8, 1, 5, 10};

        // Act
        Node root = BST_From_Level_Order.construct(arr);

        // Assert
        assertEquals(List.of(7, 4, 3, 1, 6, 5, 12, 8, 10), preorder(root));
    }

    @Test
    void testGivenExampleTwo() {
        // Arrange
        int[] arr = {1, 3, 4, 6, 7, 8};

        // Act
        Node root = BST_From_Level_Order.construct(arr);

        // Assert
        assertEquals(List.of(1, 3, 4, 6, 7, 8), preorder(root));
    }

    @Test
    void testSingleElement() {
        // Arrange
        int[] arr = {42};

        // Act
        Node root = BST_From_Level_Order.construct(arr);

        // Assert
        assertEquals(42, root.data);
        assertNull(root.left);
        assertNull(root.right);
    }

    @Test
    void testInorderIsAlwaysSorted() {
        // Arrange
        int[] arr = {50, 30, 70, 20, 40, 60, 80, 10, 25};

        // Act
        Node root = BST_From_Level_Order.construct(arr);
        List<Integer> in = inorder(root);
        List<Integer> sortedExpected = new ArrayList<>(in);
        Collections.sort(sortedExpected);

        // Assert
        assertEquals(sortedExpected, in);
    }

    @Test
    void testStrictlyIncreasingArray() {
        // Arrange: skewed case, every element goes right
        int[] arr = {1, 2, 3, 4, 5};

        // Act
        Node root = BST_From_Level_Order.construct(arr);

        // Assert: should form a right-skewed tree
        Node expected = node(1, null,
                          node(2, null,
                          node(3, null,
                          node(4, null,
                          node(5, null, null)))));
        assertEquals(preorder(expected), preorder(root));
    }

    @Test
    void testStrictlyDecreasingArray() {
        // Arrange: skewed case, every element goes left
        int[] arr = {5, 4, 3, 2, 1};

        // Act
        Node root = BST_From_Level_Order.construct(arr);

        // Assert: should form a left-skewed tree
        Node expected = node(5,
                          node(4,
                          node(3,
                          node(2,
                          node(1, null, null), null), null), null), null);
        assertEquals(preorder(expected), preorder(root));
    }

    @Test
    void testTwoElements() {
        // Arrange
        int[] arr = {10, 5};

        // Act
        Node root = BST_From_Level_Order.construct(arr);

        // Assert
        assertEquals(10, root.data);
        assertEquals(5, root.left.data);
        assertNull(root.right);
    }

    @Test
    void testAllValuesPresentRegardlessOfShape() {
        // Arrange
        int[] arr = {15, 10, 20, 8, 12, 17, 25};

        // Act
        Node root = BST_From_Level_Order.construct(arr);
        List<Integer> in = inorder(root);

        // Assert: every input value appears exactly once
        List<Integer> expected = Arrays.stream(arr).boxed().sorted().toList();
        assertEquals(expected, in);
    }
}