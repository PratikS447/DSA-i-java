package org.example.Tree.Binary_Tree;

import java.util.ArrayList;
import java.util.Arrays;

public class Path_To_A_Given_Node {
    public static ArrayList<Integer> path(Node root, int target){
        ArrayList<Integer> ans = new ArrayList<>();
        helper(root, target, new ArrayList<>(), ans);
        return ans;
    }

    public static void helper(Node root, int target, ArrayList<Integer> ls, ArrayList<Integer> ans){
        if(root == null || !ans.isEmpty()){
            return;
        }

        ls.add(root.data);
        if(root.data == target){
            ans.addAll(ls);
            return;
        }

        helper(root.left, target, ls, ans);
        helper(root.right, target, ls, ans);
    }
}
