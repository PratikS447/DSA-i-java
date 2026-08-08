package org.example.Tree.Binary_Tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LCAncestor_Test {
    private Node root;

    /*
             1
           /   \
          2     3
         / \   / \
        4   5 6   7
    */
    @BeforeEach
    void setUp() {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
    }

    @Test
    @DisplayName("LCA when target nodes are in left and right subtrees of root")
    void testNodesInDifferentSubtrees() {
        Node result = LCAncestor.ancestor(root, 4, 6);
        assertNotNull(result);
        assertEquals(1, result.data);
    }

    @Test
    @DisplayName("LCA when target nodes are in the same deep subtree")
    void testNodesInSameSubtree() {
        Node result = LCAncestor.ancestor(root, 4, 5);
        assertNotNull(result);
        assertEquals(2, result.data);
    }

    @Test
    @DisplayName("LCA when one node is the direct ancestor of the other")
    void testOneNodeIsAncestorOfAnother() {
        Node result = LCAncestor.ancestor(root, 2, 4);
        assertNotNull(result);
        assertEquals(2, result.data);
    }

    @Test
    @DisplayName("LCA when one of the target nodes is the root itself")
    void testRootIsOneOfTheNodes() {
        Node result = LCAncestor.ancestor(root, 1, 7);
        assertNotNull(result);
        assertEquals(1, result.data);
    }

    @Test
    @DisplayName("Returns null when tree root is null")
    void testNullRoot() {
        Node result = LCAncestor.ancestor(null, 4, 5);
        assertNull(result);
    }

    @Test
    @DisplayName("Returns null when neither node exists in the tree")
    void testNodesNotInTree() {
        Node result = LCAncestor.ancestor(root, 8, 9);
        assertNull(result);
    }

    @Test
    @DisplayName("Returns existing node when only one node exists in the tree")
    void testOnlyOneNodeExists() {
        Node result = LCAncestor.ancestor(root, 4, 99);
        assertNotNull(result);
        assertEquals(4, result.data);
    }
}
