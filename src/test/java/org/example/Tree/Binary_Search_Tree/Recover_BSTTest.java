package org.example.Tree.Binary_Search_Tree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Recover_BSTTest {
    private List<Integer> getInOrderTraversal(Node root) {
        List<Integer> result = new ArrayList<>();
        inOrderCollect(root, result);
        return result;
    }

    private void inOrderCollect(Node root, List<Integer> result) {
        if (root == null) return;
        inOrderCollect(root.left, result);
        result.add(root.data);
        inOrderCollect(root.right, result);
    }

    @Test
    @DisplayName("Recover tree with non-adjacent swapped nodes")
    void testNonAdjacentSwappedNodes() {
        /*
               3
              / \
             1   4
                /
               2
           In-Order before: [1, 3, 4, 2]
           Swapped nodes: 3 and 2
        */
        Node root = new Node(3);
        root.left = new Node(1);
        root.right = new Node(4);
        root.right.left = new Node(2);

        Recover_BST.recover(root);

        List<Integer> expected = List.of(1, 2, 3, 4);
        assertEquals(expected, getInOrderTraversal(root));
    }

    @Test
    @DisplayName("Recover tree with adjacent swapped nodes")
    void testAdjacentSwappedNodes() {
        /*
               2
              / \
             3   1
           In-Order before: [3, 2, 1]
           Swapped nodes: 3 and 1
        */
        Node root = new Node(2);
        root.left = new Node(3);
        root.right = new Node(1);

        Recover_BST.recover(root);

        List<Integer> expected = List.of(1, 2, 3);
        assertEquals(expected, getInOrderTraversal(root));
    }

    @Test
    @DisplayName("Ensure static state is properly reset across consecutive execution calls")
    void testMultipleConsecutiveRecoverCalls() {
        // Run 1: First broken tree
        Node tree1 = new Node(2);
        tree1.left = new Node(3);
        tree1.right = new Node(1);

        Recover_BST.recover(tree1);
        assertEquals(List.of(1, 2, 3), getInOrderTraversal(tree1));

        // Run 2: Second broken tree (Verifies state doesn't leak between runs)
        Node tree2 = new Node(3);
        tree2.left = new Node(1);
        tree2.right = new Node(4);
        tree2.right.left = new Node(2);

        Recover_BST.recover(tree2);
        assertEquals(List.of(1, 2, 3, 4), getInOrderTraversal(tree2));
    }

    @Test
    @DisplayName("Tree that is already a valid BST should remain unchanged")
    void testAlreadyValidBST() {
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);

        Recover_BST.recover(root);

        assertEquals(List.of(1, 2, 3), getInOrderTraversal(root));
    }

    @Test
    @DisplayName("Single node tree should remain unchanged")
    void testSingleNodeTree() {
        Node root = new Node(42);

        Recover_BST.recover(root);

        assertEquals(List.of(42), getInOrderTraversal(root));
    }
}
