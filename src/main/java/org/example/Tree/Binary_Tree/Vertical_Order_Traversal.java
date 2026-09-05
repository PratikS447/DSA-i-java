package org.example.Tree.Binary_Tree;

import java.util.*;

class Triplet{
    int row;
    int col;
    Node node;
    Triplet(int row, int col, Node node){
        this.row = row;
        this.col = col;
        this.node = node;
    }
}

public class Vertical_Order_Traversal {
    public List<List<Integer>> verticalTraversal(Node root) {
        if(root == null){
            return new ArrayList<>();
        }
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
        Queue<Triplet> queue = new LinkedList<>();
        queue.offer(new Triplet(0, 0, root));
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Triplet curr = queue.poll();
                int row = curr.row;
                int col = curr.col;
                Node node = curr.node;

                map.putIfAbsent(col, new TreeMap<>());
                map.get(col).putIfAbsent(row, new ArrayList<>());

                map.get(col).get(row).add(node.data);

                if(node.left != null){
                    queue.offer(new Triplet(row+1, col-1, node.left));
                }

                if(node.right != null){
                    queue.offer(new Triplet(row+1, col+1, node.right));
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(Map<Integer, List<Integer>> row: map.values()){
            List<Integer> ls = new ArrayList<>();
            for(List<Integer> col: row.values()){
                Collections.sort(col);
                ls.addAll(col);
            }
            ans.add(ls);
        }

        return ans;
    }
}
