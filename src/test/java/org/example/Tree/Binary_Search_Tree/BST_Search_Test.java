package org.example.Tree.Binary_Search_Tree;

public class BST_Search_Test {
    public static boolean is_Present(Node root, int val){
        if(root == null){
            return false;
        }
        Node curr = root;
        while(curr != null){
            if(curr.data == val){
                return true;
            }
            else if(curr.data < val){
                curr = curr.right;
            }else{
                curr = curr.left;
            }
        }
        return false;
    }
}
