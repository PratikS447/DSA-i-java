package org.example.Tree.Binary_Search_Tree;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class BST_Size_Test {
    private Node node(int val, Node left, Node right){
        Node n = new Node(val);
        n.left = left;
        n.right = right;
        return n;
    }

    @Test
    void testEmpyTree(){
        assertEquals(0, BST_Size.size(null));
    }

    @Test
    void testSingleNode(){
        Node root = node(10, null, null);
        assertEquals(1, BST_Size.size(root));
    }

    @Test
    void testOnlyLeftChild(){
        Node root = node(10, node(5, null, null), null);
        assertEquals(2, BST_Size.size(root));
    }

    @Test
    void testOnlyRightChild(){
        Node root = node(10, null, node(15, null, null));
        assertEquals(2, BST_Size.size(root));
    }

    @Test
    void testBothChilder(){
        Node root = node(10, node(5, null, null), node(15, null, null));
        assertEquals(3, BST_Size.size(root));
    }

    @Test
    void testBalancedSevenNodes(){
        Node root = node(40,
                node(20, node(10, null, null), node(30, null, null)),
                node(60, node(50, null, null), node(70, null, null)));

        assertEquals(7, BST_Size.size(root));
    }

    @Test
    void testLeftSkewed(){
        Node root = node(50,
                node(40,
                        node(30,
                                node(20,
                                        node(10, null, null),
                                        null),
                                null),
                        null),
                null);
        assertEquals(5, BST_Size.size(root));
    }

    @Test
    void testRightSkewed(){
        Node root = node(10, null,
                node(20, null,
                        node(30, null,
                                node(40, null,
                                        node(50, null, null)))));
        assertEquals(5, BST_Size.size(root));
    }

    @Test
    void testUnbalancedMix(){
        Node root = node(50,
                node(30, node(20, node(10, null, null), null), node(40, null, null)),
                node(70, null, node(80, null, null)));
        assertEquals(7, BST_Size.size(root));
    }

    @Test
    void testLargerBalancedFifteenNodes(){
        Node root = node(8,
                node(4,
                        node(2, node(1,null,null), node(3,null,null)),
                        node(6, node(5,null,null), node(7,null,null))),
                node(12,
                        node(10, node(9,null,null), node(11,null,null)),
                        node(14, node(13,null,null), node(15,null,null))));
        assertEquals(15, BST_Size.size(root));
    }

}
