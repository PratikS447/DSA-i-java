package org.example.Tree.Binary_Tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Path_To_A_Given_NodeTest {
    private Node root;

    private Node node(int val, Node left, Node right) {
        Node n = new Node(val);
        n.left = left;
        n.right = right;
        return n;
    }

    private Node leaf(int val) {
        return node(val, null, null);
    }

    @BeforeEach
    void setUp() {
        /*
                 1
               /   \
              2     3
             / \   / \
            4   5 6   7
        */
        root = node(1,
                node(2, leaf(4), leaf(5)),
                node(3, leaf(6), leaf(7))
        );
    }

    @Test
    void testPathToRootNode() {
        List<Integer> expected = List.of(1);
        ArrayList<Integer> actual = Path_To_A_Given_Node.path(root, 1);
        assertEquals(expected, actual);
    }

    @Test
    void testPathToLeftLeaf() {
        List<Integer> expected = List.of(1, 2, 4);
        ArrayList<Integer> actual = Path_To_A_Given_Node.path(root, 4);
        assertEquals(expected, actual);
    }

    @Test
    void testPathToRightLeaf() {
        List<Integer> expected = List.of(1, 3, 7);
        ArrayList<Integer> actual = Path_To_A_Given_Node.path(root, 7);
        assertEquals(expected, actual);
    }

    @Test
    void testTargetNotFound() {
        ArrayList<Integer> actual = Path_To_A_Given_Node.path(root, 99);
        assertTrue(actual.isEmpty());
    }

    @Test
    void testNullRoot() {
        ArrayList<Integer> actual = Path_To_A_Given_Node.path(null, 5);
        assertTrue(actual.isEmpty());
    }
}
