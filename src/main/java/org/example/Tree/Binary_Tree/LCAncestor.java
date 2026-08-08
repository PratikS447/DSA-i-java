package org.example.Tree.Binary_Tree;

public class LCAncestor {
    public static Node ancestor(Node root, int n1, int n2){
        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }

        Node left_node = ancestor(root.left, n1, n2);
        Node right_node = ancestor(root.right, n1, n2);

        if(left_node != null && right_node != null){
            return root;
        } else if (left_node != null) {
            return left_node;
        }else {
            return right_node;
        }
    }
}
