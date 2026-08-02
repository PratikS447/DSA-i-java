package org.example.Tree.Binary_Search_Tree;

public class BST_Search {
    public static boolean find(Node root, int data){
        Node curr = root;
        while(curr != null){
            if(curr.data == data) return true;

            else if (curr.data < data){
                curr = curr.right;
            }

            else{
                curr = curr.left;
            }
        }
        return false;
    }

}
