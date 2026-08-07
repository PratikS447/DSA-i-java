package org.example.Tree.Binary_Tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiagonalTraversalTest {

    private Diagonal_traversal solver;

    @BeforeEach
    void setUp() {
        solver = new Diagonal_traversal();
    }

    private Node node(int val, Node left, Node right) {
        Node n = new Node(val);
        n.left = left;
        n.right = right;
        return n;
    }

    @Test
    void testNullRoot() {
        assertEquals(Collections.emptyList(), solver.traversal(null));
    }

    @Test
    void testSingleNode() {
        Node root = node(10, null, null);
        assertEquals(List.of(10), solver.traversal(root));
    }

    @Test
    void testRightSkewedTree() {
        // Tree: 1 -> 2 -> 3 (all right children)
        Node root = node(1, null, 
                        node(2, null, 
                        node(3, null, null)));

        assertEquals(List.of(1, 2, 3), solver.traversal(root));
    }

    @Test
    void testLeftSkewedTree() {
        // Tree: 1 -> 2 -> 3 (all left children)
        Node root = node(1, 
                    node(2, 
                    node(3, null, null), null), null);

        assertEquals(List.of(1, 2, 3), solver.traversal(root));
    }

    @Test
    void testStandardBinaryTree() {
        /*
                   8
                 /   \
                3     10
               / \      \
              1   6      14
                 / \     /
                4   7   13
        
        Expected Diagonals:
        1: [8, 10, 14]
        2: [3, 6, 7, 13]
        3: [1, 4]
        */
        Node root = node(8,
            node(3,
                node(1, null, null),
                node(6,
                    node(4, null, null),
                    node(7, null, null)
                )
            ),
            node(10,
                null,
                node(14,
                    node(13, null, null),
                    null
                )
            )
        );

        List<Integer> expected = List.of(8, 10, 14, 3, 6, 7, 13, 1, 4);
        assertEquals(expected, solver.traversal(root));
    }
}