package org.example.Tree.Binary_Search_Tree;

public class BST_Max_Min {
    public static int find_Max(Node root){
        if (root.right == null){
            return root.data;
        }
        return find_Max(root.right);
    }

    public static int find_Min(Node root){
        if(root.left == null){
            return root.data;
        }
        return find_Min(root.left);
    }
}
