package org.example.Tree.Binary_Search_Tree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Delete_A_Node_BST_Test {
    //  BUILD A BST BY INSERTING VALUE
    private Node node(int val, Node left, Node right){
        Node n = new Node(val);
        n.left = left;
        n.right = right;
        return n;
    }

    // Helper: get inorder traversal as a list
    private void inorderCollect(Node root, List<Integer> out){
        if(root == null) return;
        inorderCollect(root.left, out);
        out.add(root.data);
        inorderCollect(root.right, out);
    }

    private List<Integer> inorderList(Node root){
        List<Integer> res = new ArrayList<>();
        inorderCollect(root, res);
        return res;
    }

    @Test
    void testDeleteLeafNode(){
        Node root = node(5, node(3, null, null), node(8, null, null));
        // Act
        root = Delete_A_Node_BST.deleteNode(root, 3);
        assertEquals(List.of(5, 8), inorderList(root));
    }


    void testDeleteNodeWithOnlyLeftChild(){
        Node root = node(5, node(3, node(2, null, null), null), null);
        // Act
        root = Delete_A_Node_BST.deleteNode(root, 3);
        assertEquals(List.of(2, 5), inorderList(root));
    }

    @Test
    void testDeleteNodeWithOnlyRightChild(){
        // Arrange:      5
        //              /
        //             3
        //              \
        //               4
        Node root = node(5, node(3, null, node(4, null, null)), null);

        // Act
        root = Delete_A_Node_BST.deleteNode(root, 3);

        // Assert: 4 should take 3's place
        assertEquals(List.of(4, 5), inorderList(root));
    }

    @Test
    void testDeleteNodeWithTwoChildren(){
        // Arrange:            50
        //                   /    \
        //                 30      70
        //                /  \    /  \
        //              20   40  60   80
        Node root = node(50,
                node(30, node(20, null, null), node(40, null, null)),
                node(70, node(60, null, null), node(80, null, null)));

        // Act: delete 30, which has two children (20 and 40)
        root = Delete_A_Node_BST.deleteNode(root, 30);

        // Assert: inorder successor of 30 is 40, so 40 replaces 30, and old 40 node is removed
        assertEquals(List.of(20, 40, 50, 60, 70, 80), inorderList(root));
        assertFalse(inorderList(root).contains(30));
    }

    @Test
    void testDeleteRootWithTwoChildren(){
        // Arrange: same tree as above, but delete the root itself
        Node root = node(50,
                node(30, node(20, null, null), node(40, null, null)),
                node(70, node(60, null, null), node(80, null, null)));

        // Act: delete root (50), successor should be 60
        root = Delete_A_Node_BST.deleteNode(root, 50);

        // Assert
        assertEquals(60, root.data);
        assertEquals(List.of(20, 30, 40, 60, 70, 80), inorderList(root));
    }

    @Test
    void testDeleteOnlyNodeInTree(){
        // Arrange: single-node tree
        Node root = node(10, null, null);

        // Act
        root = Delete_A_Node_BST.deleteNode(root, 10);

        // Assert: tree becomes empty
        assertNull(root);
    }

    @Test
    void testDeleteFromEmptyTree(){
        // Arrange: no tree at all
        Node root = null;

        // Act
        root = Delete_A_Node_BST.deleteNode(root, 100);

        // Assert: still null, no exception thrown
        assertNull(root);
    }

    @Test
    void testDeleteValueNotPresent(){
        // Arrange:      5
        //              / \
        //             3   8
        Node root = node(5, node(3, null, null), node(8, null, null));

        // Act: try deleting a value that doesn't exist
        root = Delete_A_Node_BST.deleteNode(root, 100);

        // Assert: tree unchanged
        assertEquals(List.of(3, 5, 8), inorderList(root));
    }

    @Test
    void testInorderSuccessorPicksSmallestGreaterValue(){
        // Arrange:            20
        //                    /  \
        //                  10    30
        //                       /
        //                     25
        //                       \
        //                       27
        Node root = node(20,
                node(10, null, null),
                node(30, node(25, null, node(27, null, null)), null));

        // Act: delete 20 (two children) — successor should be smallest value > 20, i.e. 25
        root = Delete_A_Node_BST.deleteNode(root, 20);

        // Assert
        assertEquals(25, root.data);
        assertEquals(List.of(10, 25, 27, 30), inorderList(root));
    }
}
