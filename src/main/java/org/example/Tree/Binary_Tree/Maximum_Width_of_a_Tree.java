package org.example.Tree.Binary_Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Maximum_Width_of_a_Tree {
    public static int max_width(Node root){
        int max_Len = Integer.MIN_VALUE;
        Map<Node, Integer> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        map.put(root, 0);
        while (!queue.isEmpty()){
            int size = queue.size();
            int first = map.get(queue.peek());
            int last = map.get(queue.peek());
            for (int i = 0; i < size; i++){
                Node curr = queue.poll();
                last = map.get(curr);
                if(curr.left != null){
                    queue.offer(curr.left);
                    map.put(curr.left, 2*map.get(curr)+1);
                }
                if(curr.right != null){
                    queue.offer(curr.right);
                    map.put(curr.right, 2*map.get(curr)+2);
                }
            }
            max_Len = Math.max(max_Len, last -first +1);
        }
        return max_Len;
    }

}
