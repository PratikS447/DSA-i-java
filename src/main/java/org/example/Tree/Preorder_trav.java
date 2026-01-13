package org.example.Tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Preorder_trav {
    static class Tree_Node{
        int val;
        Tree_Node left;
        Tree_Node right;
        Tree_Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static Tree_Node Insert(Tree_Node root, int val){
        if (root == null){
            return new Tree_Node(val);
        }
        if (val < root.val){
            root.left = Insert(root.left, val);
        } else if (val > root.val) {
            root.right = Insert(root.right, val);
        }

        return root;
    }

    public static List<Integer> preorder(Tree_Node root){
        List<Integer> ls = new ArrayList<>();
        traversal(root, ls);
        return ls;
    }

    public static void traversal(Tree_Node root, List<Integer> ls){
        if (root == null){
            return;
        }

        ls.add(root.val);
        traversal(root.left, ls);
        traversal(root.right, ls);
    }

    public static void main(String args[]){
        Tree_Node root = null;
        int [] arr = {10, 5, 7, 15};

        for (int i: arr){
            root = Insert(root, i);
        }

        System.out.print(preorder(root));
    }

}
