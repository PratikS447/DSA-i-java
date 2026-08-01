package org.example.Tree.Binary_Search_Tree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Predecessor_Successor_Test {
    // Helper to build a Node quickly
    private Node node(int val, Node left, Node right){
        Node n = new Node(val);
        n.left = left;
        n.right = right;
        return n;
    }

    @Test
    void testBasicCase(){
        Node root = node(50, node(30, node(20, null, null), node(40, null, null)),
                node(70, node(60, null, null), node(80, null, null)));

        ArrayList<Node> res = Predecessor_Successor.findPreSuc(root, 50);
        assertEquals(40, res.get(0).data);
        assertEquals(60, res.get(1).data);
    }

    @Test
    void testKeyIsMinimum(){
        Node root = node(50,
                node(30, node(20, null, null), node(40, null, null)),
                node(70, node(60, null, null), node(80, null, null)));

        ArrayList<Node> res = Predecessor_Successor.findPreSuc(root, 20);
        assertNull(res.get(0));
        assertEquals(30, res.get(1).data);
    }

    @Test
    void testKeyIsMaximum(){
        Node root = node(50,
                node(30, node(20,null,null), node(40,null,null)),
                node(70, node(60,null,null), node(80,null,null)));

        ArrayList<Node> res = Predecessor_Successor.findPreSuc(root, 80);
        assertEquals(70, res.get(0).data);
        assertNull(res.get(1));
    }

    @Test
    void testKeyNotPresentBetweenNodes(){
        Node root = node(50,
                node(30, node(20,null,null), node(40,null,null)),
                node(70, node(60,null,null), node(80,null,null)));

        ArrayList<Node> res = Predecessor_Successor.findPreSuc(root, 45);
        assertEquals(40, res.get(0).data);
        assertEquals(50, res.get(1).data);
    }

    @Test
    void testKeyNotPresentSmallerThanAll(){
        Node root = node(50,
                node(30, node(20,null,null), node(40,null,null)),
                node(70, node(60,null,null), node(80,null,null)));

        ArrayList<Node> res = Predecessor_Successor.findPreSuc(root, 5);
        assertNull(res.get(0));
        assertEquals(20, res.get(1).data);
    }

    @Test
    void testKeyNotPresentLargerThanAll(){
        Node root = node(50,
                node(30, node(20,null,null), node(40,null,null)),
                node(70, node(60,null,null), node(80,null,null)));

        ArrayList<Node> res = Predecessor_Successor.findPreSuc(root, 100);
        assertEquals(80, res.get(0).data);
        assertNull(res.get(1));
    }

    @Test
    void testSingleNode(){
        Node root = node(10,null,null);

        ArrayList<Node> res = Predecessor_Successor.findPreSuc(root, 10);
        assertNull(res.get(0));
        assertNull(res.get(1));
    }

    @Test
    void testOnlyLeftSubtree(){
        Node root = node(50, node(30, node(10,null,null), null), null);

        ArrayList<Node> res = Predecessor_Successor.findPreSuc(root, 10);
        assertNull(res.get(0));
        assertEquals(30, res.get(1).data);
    }

    @Test
    void testOnlyRightSubtree(){
        Node root = node(10, null, node(30, null, node(50,null,null)));

        ArrayList<Node> res = Predecessor_Successor.findPreSuc(root, 50);
        assertEquals(30, res.get(0).data);
        assertNull(res.get(1));
    }

    @Test
    void testSkewedTreeMiddleKey(){
        // 10 -> 20 -> 30 -> 40 -> 50 (right-skewed)
        Node root = node(10, null,
                node(20, null,
                        node(30, null,
                                node(40, null,
                                        node(50, null, null)))));

        ArrayList<Node> res = Predecessor_Successor.findPreSuc(root, 30);
        assertEquals(20, res.get(0).data);
        assertEquals(40, res.get(1).data);
    }

    @Test
    void testPredecessorViaRightSubtreeOfLeftChild(){
        Node root = node(20,
                node(10, null, node(15,null,null)),
                node(30,null,null));

        ArrayList<Node> res = Predecessor_Successor.findPreSuc(root, 20);
        assertEquals(15, res.get(0).data);
        assertEquals(30, res.get(1).data);
    }
}
