package org.example.Tree.Binary_Search_Tree;

public class Delete_A_Node_BST {
    public static Node deleteNode(Node root, int val){
        if(root == null) return null;
        if(root.data > val){
            root.left = deleteNode(root.left, val);
        }
        else if(root.data < val){
            root.right = deleteNode(root.right, val);
        }
        // FOUND THE NODE
        else{
            // CASE 1 : WHEN CHILD NODE ARE NULL
            if(root.left == null && root.right == null){
                return null;
            }
            // CASE 2 : WHEN CHILD NODE ARE NOT NULL
            else if(root.left != null && root.right != null){
                int succ = inorder_Successor(root, val);
                root.data = succ;
                root.right = deleteNode(root.right, succ);
            }else{
                if(root.right != null){
                    return root.right;
                }
                if (root.left != null){
                    return root.left;
                }
            }
        }

        return root;
    }

    public static int inorder_Successor(Node root, int val){
        int succ = 0;
        Node curr = root;
        while (curr != null){
            if(curr.data > val){
                succ = curr.data;
                curr = curr.left;
            }else{
                curr = curr.right;
            }
        }
        return succ;
    }
}
