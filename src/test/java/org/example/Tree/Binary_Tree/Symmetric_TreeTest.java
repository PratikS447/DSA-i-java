package org.example.Tree.Binary_Tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Symmetric_TreeTest {
    private Node node(int val, Node left, Node right) {
        Node n = new Node(val);
        n.left = left;
        n.right = right;
        return n;
    }

    private Node leaf(int val) {
        return node(val, null, null);
    }

    @Test
    void testNullRoot() {
        assertTrue(Symmetric_Tree.isSymmetric(null));
    }

    @Test
    void testSingleNode() {
        assertTrue(Symmetric_Tree.isSymmetric(leaf(1)));
    }

    @Test
    void testSymmetricTree() {
        /*
                 1
               /   \
              2     2
             / \   / \
            3   4 4   3
        */
        Node root = node(1,
                node(2, leaf(3), leaf(4)),
                node(2, leaf(4), leaf(3))
        );
        assertTrue(Symmetric_Tree.isSymmetric(root));
    }

    @Test
    void testAsymmetricStructure() {
        /*
                 1
               /   \
              2     2
               \     \
                3     3
        */
        Node root = node(1,
                node(2, null, leaf(3)),
                node(2, null, leaf(3))
        );
        assertFalse(Symmetric_Tree.isSymmetric(root));
    }

    @Test
    void testPartialAsymmetricTree() {
        /*
                 1
               /   \
              2     2
             /       \
            3         3
           /           \
          4             5
        */
        Node root = node(1,
                node(2, node(3, leaf(4), null), null),
                node(2, null, node(3, null, leaf(5)))
        );
        assertFalse(Symmetric_Tree.isSymmetric(root));
    }
}
