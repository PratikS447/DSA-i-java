package org.example.Tree.Binary_Search_Tree;

public class BST_From_Preorder {
    static int i = 0;
    public static Node bst_from_preorder(int preorder[]){
        return helper(preorder, Integer.MAX_VALUE);
    }

    public static Node helper(int preorder[], int upper_bound){
        if(i == preorder.length || preorder[i] > upper_bound){
            return null;
        }
        Node root = new Node(preorder[i++]);
        root.left = helper(preorder, root.data);
        root.right = helper(preorder, upper_bound);
        return root;
    }
}
