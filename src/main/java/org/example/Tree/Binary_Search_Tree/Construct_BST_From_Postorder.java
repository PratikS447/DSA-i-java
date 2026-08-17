package org.example.Tree.Binary_Search_Tree;

public class Construct_BST_From_Postorder {
    static int idx = 0;
    public static Node construct(int post_order[]){
        idx = post_order.length -1;
        return helper(post_order, Integer.MIN_VALUE);
    }

    public static Node helper(int post_order[], int prev){
        if(idx == -1 || prev > post_order[idx]){
            return null;
        }
        Node node = new Node(post_order[idx--]);
        node.right = helper(post_order, node.data);
        node.left = helper(post_order, prev);

        return node;
    }
}
