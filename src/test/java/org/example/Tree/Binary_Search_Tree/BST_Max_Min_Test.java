package org.example.Tree.Binary_Search_Tree;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class BST_Max_Min_Test {
    private Node node(int val, Node left, Node right){
        Node n = new Node(val);
        n.left = left;
        n.right = right;
        return n;
    }

    @Test
    void testSingleNode(){
        Node root = node(10, null, null);
        assertEquals(10, BST_Max_Min.find_Max(root));
        assertEquals(10, BST_Max_Min.find_Min(root));
    }

    @Test
    void testOnlyLeftChild(){
        Node root = node(10, node(5, null, null), null);
        assertEquals(10, BST_Max_Min.find_Max(root));
        assertEquals(5, BST_Max_Min.find_Min(root));
    }

    @Test
    void testOnlyRightChild(){
        Node root = node(10, null, node(15, null, null));
        assertEquals(15, BST_Max_Min.find_Max(root));
        assertEquals(10, BST_Max_Min.find_Min(root));
    }

    @Test
    void testBothChildren(){
        Node root = node(10, node(5, null, null), node(15, null, null));
        assertEquals(15, BST_Max_Min.find_Max(root));
        assertEquals(5, BST_Max_Min.find_Min(root));
    }

    @Test
    void testBalancedSevenNodes(){
        Node root = node(40,
                node(20, node(10, null, null), node(30, null, null)),
                node(60, node(50, null, null), node(70, null, null)));
        assertEquals(70, BST_Max_Min.find_Max(root));
        assertEquals(10, BST_Max_Min.find_Min(root));
    }

    @Test
    void testLeftSkewed(){
        // 50 -> 40 -> 30 -> 20 -> 10 (all left)
        Node root = node(50,
                node(40,
                        node(30,
                                node(20,
                                        node(10, null, null),
                                        null),
                                null),
                        null),
                null);
        assertEquals(50, BST_Max_Min.find_Max(root));
        assertEquals(10, BST_Max_Min.find_Min(root));
    }

    @Test
    void testRightSkewed(){
        // 10 -> 20 -> 30 -> 40 -> 50 (all right)
        Node root = node(10, null,
                node(20, null,
                        node(30, null,
                                node(40, null,
                                        node(50, null, null)))));
        assertEquals(50, BST_Max_Min.find_Max(root));
        assertEquals(10, BST_Max_Min.find_Min(root));
    }

    @Test
    void testWithNegativeValues(){
        Node root = node(0, node(-10, null, null), node(10, null, null));
        assertEquals(10, BST_Max_Min.find_Max(root));
        assertEquals(-10, BST_Max_Min.find_Min(root));
    }

    @Test
    void testMaxIsDeepInRightSubtreeOfLeftChild(){
        // Ensures min/max descend correctly through a mixed structure,
        // not just the immediate child
        Node root = node(20,
                node(10, node(5,null,null), node(15,null,null)),
                node(30, node(25,null,null), node(35,null,null)));
        assertEquals(35, BST_Max_Min.find_Max(root));
        assertEquals(5, BST_Max_Min.find_Min(root));
    }
}
