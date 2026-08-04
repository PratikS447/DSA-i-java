package org.example.Tree.Binary_Search_Tree;

public class LCA_In_BST {
    public static Node lca(Node root, int p, int q){
        Node curr = root;
        while(curr != null){
            if(curr.data > p && curr.data > q){
                curr = curr.left;
            }else if(curr.data < p && curr.data < q){
                curr = curr.right;
            }else{
                return curr;
            }
        }
        return null;
    }
}
