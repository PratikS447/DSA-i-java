package org.example.Tree.Binary_Search_Tree;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class LCA_In_BST_Test {

    private Node node(int val, Node left, Node right){
        Node n = new Node(val);
        n.left = left;
        n.right = right;
        return n;
    }

    // Shared test tree
    //            8
    //          /   \
    //         3     10
    //        / \      \
    //       1   6     14
    //          / \    /
    //         4   7  13
    private Node buildSampleTree(){
        return node(8,
                node(3,
                        node(1, null, null),
                        node(6, node(4, null, null), node(7, null, null))),
                node(10, null,
                        node(14, node(13, null, null), null)));
    }

    @Test
    @DisplayName("LCA of two nodes in left subtree should return their common ancestor")
    void testLCA_BothInLeftSubtree() {
        Node root = buildSampleTree();
        Node result = LCA_In_BST.lca(root, 1, 4);
        assertNotNull(result);
        assertEquals(3, result.data, "LCA of 1 and 4 should be node 3");
    }

    @Test
    @DisplayName("LCA of two nodes in right subtree should return their common ancestor")
    void testLCA_BothInRightSubtree() {
        Node root = buildSampleTree();
        Node result = LCA_In_BST.lca(root, 13, 14);
        assertNotNull(result);
        assertEquals(14, result.data, "LCA of 13 and 14 should be node 14");
    }

    @Test
    @DisplayName("LCA of nodes split across left and right of root should return root")
    void testLCA_SplitAcrossRoot() {
        Node root = buildSampleTree();
        Node result = LCA_In_BST.lca(root, 1, 13);
        assertNotNull(result);
        assertEquals(8, result.data, "LCA of 1 and 13 should be root node 8");
    }

    @Test
    @DisplayName("LCA where one node is an ancestor of the other should return the ancestor itself")
    void testLCA_OneIsAncestorOfOther() {
        Node root = buildSampleTree();
        Node result = LCA_In_BST.lca(root, 3, 7);
        assertNotNull(result);
        assertEquals(3, result.data, "Since 3 is an ancestor of 7, LCA should be node 3 itself");
    }

    @Test
    @DisplayName("LCA where one node is the root should return the root")
    void testLCA_OneNodeIsRoot() {
        Node root = buildSampleTree();
        Node result = LCA_In_BST.lca(root, 8, 4);
        assertNotNull(result);
        assertEquals(8, result.data, "Since root itself is one of the nodes, LCA should be root");
    }

    @Test
    @DisplayName("LCA of a node with itself should return that node")
    void testLCA_SameNodeTwice() {
        Node root = buildSampleTree();
        Node result = LCA_In_BST.lca(root, 6, 6);
        assertNotNull(result);
        assertEquals(6, result.data, "LCA of a node with itself should be that node");
    }

    @Test
    @DisplayName("LCA on single-node tree should return that node")
    void testLCA_SingleNodeTree() {
        Node root = node(5, null, null);
        Node result = LCA_In_BST.lca(root, 5, 5);
        assertNotNull(result);
        assertEquals(5, result.data, "LCA on single node tree should return that node");
    }

    @Test
    @DisplayName("LCA of two immediate children should return their shared parent")
    void testLCA_TwoImmediateChildren() {
        Node root = buildSampleTree();
        Node result = LCA_In_BST.lca(root, 4, 7);
        assertNotNull(result);
        assertEquals(6, result.data, "LCA of 4 and 7 (children of 6) should be node 6");
    }
}