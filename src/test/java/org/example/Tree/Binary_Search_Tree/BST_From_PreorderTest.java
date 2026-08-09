package org.example.Tree.Binary_Search_Tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BST_From_PreorderTest {

    @BeforeEach
    void setUp() {
        // Crucial: Reset static pointer 'i' before every test to prevent cross-test contamination
        BST_From_Preorder.i = 0;
    }

    @Test
    void testStandardBST() {
        int[] preorder = {8, 5, 1, 7, 10, 12};
        Node root = BST_From_Preorder.bst_from_preorder(preorder);

        assertNotNull(root);
        assertEquals(8, root.data);

        // Verify structural topology
        assertEquals(5, root.left.data);
        assertEquals(1, root.left.left.data);
        assertEquals(7, root.left.right.data);
        assertEquals(10, root.right.data);
        assertEquals(12, root.right.right.data);

        // Verify BST property (In-order traversal must be strictly sorted)
        List<Integer> inorderList = new ArrayList<>();
        collectInorder(root, inorderList);
        assertEquals(List.of(1, 5, 7, 8, 10, 12), inorderList);
    }

    @Test
    void testSingleNode() {
        int[] preorder = {42};
        Node root = BST_From_Preorder.bst_from_preorder(preorder);

        assertNotNull(root);
        assertEquals(42, root.data);
        assertNull(root.left);
        assertNull(root.right);
    }

    @Test
    void testLeftSkewedTree() {
        int[] preorder = {5, 4, 3, 2, 1};
        Node root = BST_From_Preorder.bst_from_preorder(preorder);

        assertNotNull(root);
        assertEquals(5, root.data);
        assertEquals(4, root.left.data);
        assertEquals(3, root.left.left.data);
        assertEquals(2, root.left.left.left.data);
        assertEquals(1, root.left.left.left.left.data);
        assertNull(root.right);
    }

    @Test
    void testRightSkewedTree() {
        int[] preorder = {1, 2, 3, 4, 5};
        Node root = BST_From_Preorder.bst_from_preorder(preorder);

        assertNotNull(root);
        assertEquals(1, root.data);
        assertEquals(2, root.right.data);
        assertEquals(3, root.right.right.data);
        assertEquals(4, root.right.right.right.data);
        assertEquals(5, root.right.right.right.right.data);
        assertNull(root.left);
    }

    @Test
    void testEmptyArray() {
        int[] preorder = {};
        Node root = BST_From_Preorder.bst_from_preorder(preorder);

        assertNull(root);
    }

    // Helper method to collect values via in-order traversal
    private void collectInorder(Node root, List<Integer> list) {
        if (root == null) return;
        collectInorder(root.left, list);
        list.add(root.data);
        collectInorder(root.right, list);
    }
}