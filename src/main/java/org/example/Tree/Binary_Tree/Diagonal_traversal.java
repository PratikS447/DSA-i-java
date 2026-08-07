package org.example.Tree.Binary_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Diagonal_traversal {
    public List<Integer> traversal(Node root){
        List<Integer> ans = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int k = queue.size();
            for (int i = 0; i < k; i++){
                Node curr = queue.poll();
                while (curr != null){
                    ans.add(curr.data);
                    if(curr.left != null){
                        queue.offer(curr.left);
                    }
                    curr = curr.right;
                }
            }
        }
        return ans;
    }
}
