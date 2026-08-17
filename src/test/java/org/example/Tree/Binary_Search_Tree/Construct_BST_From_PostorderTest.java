package org.example.Tree.Binary_Search_Tree;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class Construct_BST_From_PostorderTest {

    // Helper method to collect Inorder traversal (Left -> Root -> Right)
    private List<Integer> getInorder(Node root) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }

    private void inorderHelper(Node node, List<Integer> result) {
        if (node == null) return;
        inorderHelper(node.left, result);
        result.add(node.data);
        inorderHelper(node.right, result);
    }

    @Test
    @DisplayName("Standard balanced/unbalanced BST")
    void testStandardBST() {
        int[] postOrder = {1, 7, 5, 50, 40, 10};
        Node root = Construct_BST_From_Postorder.construct(postOrder);

        List<Integer> expectedInorder = List.of(1, 5, 7, 10, 40, 50);
        assertEquals(expectedInorder, getInorder(root));
        assertEquals(10, root.data);
    }

    @Test
    @DisplayName("Single element tree")
    void testSingleElement() {
        int[] postOrder = {42};
        Node root = Construct_BST_From_Postorder.construct(postOrder);

        assertNotNull(root);
        assertEquals(42, root.data);
        assertNull(root.left);
        assertNull(root.right);
    }

    @Test
    @DisplayName("Empty array input")
    void testEmptyArray() {
        int[] postOrder = {};
        Node root = Construct_BST_From_Postorder.construct(postOrder);

        assertNull(root);
    }

    @Test
    @DisplayName("Left-skewed tree")
    void testLeftSkewedTree() {
        // Tree: 4 -> left 3 -> left 2 -> left 1
        int[] postOrder = {1, 2, 3, 4};
        Node root = Construct_BST_From_Postorder.construct(postOrder);

        List<Integer> expectedInorder = List.of(1, 2, 3, 4);
        assertEquals(expectedInorder, getInorder(root));
        assertEquals(4, root.data);
        assertNull(root.right);
    }

    @Test
    @DisplayName("Right-skewed tree")
    void testRightSkewedTree() {
        // Tree: 1 -> right 2 -> right 3 -> right 4
        int[] postOrder = {4, 3, 2, 1};
        Node root = Construct_BST_From_Postorder.construct(postOrder);

        List<Integer> expectedInorder = List.of(1, 2, 3, 4);
        assertEquals(expectedInorder, getInorder(root));
        assertEquals(1, root.data);
        assertNull(root.left);
    }

    @Test
    @DisplayName("Reset state test (Multiple consecutive calls)")
    void testStaticStateReset() {
        // Verifies static variable `idx` properly resets between consecutive runs
        int[] postOrder1 = {1, 3, 2};
        int[] postOrder2 = {10, 30, 20};

        Node root1 = Construct_BST_From_Postorder.construct(postOrder1);
        Node root2 = Construct_BST_From_Postorder.construct(postOrder2);

        assertEquals(List.of(1, 2, 3), getInorder(root1));
        assertEquals(List.of(10, 20, 30), getInorder(root2));
    }
}