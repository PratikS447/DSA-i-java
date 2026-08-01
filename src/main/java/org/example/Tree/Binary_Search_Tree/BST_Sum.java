package org.example.Tree.Binary_Search_Tree;

public class BST_Sum {
    public static int sum(Node root){
        if (root == null){
            return 0;
        }
        int left = sum(root.left);
        int right = sum(root.right);

        return left+right+root.data;
    }
}
