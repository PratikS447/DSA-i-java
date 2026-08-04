package org.example.Tree.Binary_Search_Tree;

class Answer{
    long prev = Long.MIN_VALUE;
    boolean res = true;
}
public class Valid_BST {
    public static boolean isValid(Node root){
        Answer ans = new Answer();
        inOrder(root, ans);
        return ans.res;
    }

    public static void inOrder(Node root, Answer ans){
        if(root == null) return;
        inOrder(root.left, ans);
        if(root.data <= ans.prev) ans.res = false;
        ans.prev = root.data;
        inOrder(root.right, ans);
    }
}
