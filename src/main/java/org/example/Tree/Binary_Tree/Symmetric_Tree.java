package org.example.Tree.Binary_Tree;

public class Symmetric_Tree {
    public static boolean isSymmetric(Node root){
        if (root == null) return true;
       return helper(root.left, root.right);
    }

    public static boolean helper(Node root_left, Node root_right){
        if (root_left == null && root_right == null){
            return true;
        }

        if(root_left == null || root_right == null){
            return false;
        }

        if(root_left.data != root_right.data){
            return false;
        }

        return helper(root_left.left, root_right.right) || helper(root_left.right, root_right.left);
    }
}
