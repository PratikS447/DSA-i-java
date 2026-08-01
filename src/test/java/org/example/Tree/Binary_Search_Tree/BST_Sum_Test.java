package org.example.Tree.Binary_Search_Tree;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class BST_Sum_Test {
    private Node node(int val, Node left, Node right){
        Node n = new Node(val);
        n.left = left;
        n.right = right;
        return n;
    }
    @Test
    void testEmptyTree(){
        assertEquals(0, BST_Sum.sum(null));
    }

    @Test
    void testSingleNode(){
        Node root = node(10, null, null);
        assertEquals(10, BST_Sum.sum(root));
    }

    @Test
    void testOnlyLeftChild(){
        Node root = node(10, node(5, null, null), null);
        assertEquals(15, BST_Sum.sum(root));
    }

    @Test
    void testOnlyRightChild(){
        Node root = node(10, null, node(15, null, null));
        assertEquals(25, BST_Sum.sum(root));
    }

    @Test
    void testBothChildren(){
        Node root = node(10, node(5, null, null), node(15, null, null));
        assertEquals(30, BST_Sum.sum(root));
    }

    @Test
    void testBalancedSevenNodes(){
        Node root = node(40,
                node(20, node(10, null, null), node(30, null, null)),
                node(60, node(50, null, null), node(70, null, null)));
        // sum = 40+20+10+30+60+50+70 = 280
        assertEquals(280, BST_Sum.sum(root));
    }

    @Test
    void testLeftSkewed(){
        // 50 -> 40 -> 30 -> 20 -> 10
        Node root = node(50,
                node(40,
                        node(30,
                                node(20,
                                        node(10, null, null),
                                        null),
                                null),
                        null),
                null);
        // sum = 50+40+30+20+10 = 150
        assertEquals(150, BST_Sum.sum(root));
    }

    @Test
    void testRightSkewed(){
        // 10 -> 20 -> 30 -> 40 -> 50
        Node root = node(10, null,
                node(20, null,
                        node(30, null,
                                node(40, null,
                                        node(50, null, null)))));
        // sum = 10+20+30+40+50 = 150
        assertEquals(150, BST_Sum.sum(root));
    }

    @Test
    void testWithNegativeValues(){
        Node root = node(0, node(-5, null, null), node(5, null, null));
        // sum = 0 + (-5) + 5 = 0
        assertEquals(0, BST_Sum.sum(root));
    }

    @Test
    void testAllNegativeValues(){
        Node root = node(-10, node(-20, null, null), node(-5, null, null));
        // sum = -10 + -20 + -5 = -35
        assertEquals(-35, BST_Sum.sum(root));
    }
}
