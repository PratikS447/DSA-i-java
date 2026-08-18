package org.example.Tree.Binary_Search_Tree;

public class BST_From_Level_Order {
    public static Node construct(int arr[]){
        Node curr = null;
        for (int a: arr){
            curr = insert(curr, a);
        }
        return curr;
    }

    public static Node insert(Node root, int val){
        if(root == null) return new Node(val);
        if(root.data > val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }
}
