package org.example.Tree.Binary_Search_Tree;


public class BST_Size {
    public static int size(Node root){
        if(root == null){
            return 0;
        }
        int left = size(root.left);
        int right = size(root.right);
        return left+right+1;
    }
}
