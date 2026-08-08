package org.example.Tree.Binary_Search_Tree;

public class Recover_BST {
    static Node first = null;
    static Node second = null;
    static Node prev = null;
    public static void inOrder(Node root){
        if(root == null) return;
        inOrder(root.left);
        if (prev != null && prev.data > root.data){
            if(first == null){
                first = prev;
            }
            second = root;
        }
        prev = root;
        inOrder(root.right);
    }

    public static void recover(Node root){
        first = null;
        second = null;
        prev = null;

        inOrder(root);

        // Guard against already valid trees
        if (first != null && second != null) {
            int temp = first.data;
            first.data = second.data;
            second.data = temp;
        }
    }
}
