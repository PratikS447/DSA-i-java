package org.example.Tree.Binary_Search_Tree;
import java.util.ArrayList;
import java.util.Arrays;

public class Predecessor_Successor {
    public static ArrayList<Node> findPreSuc(Node root, int val){
        Node prec = null;
        Node curr = root;
        while(curr != null){
            if(curr.data < val){
                prec = curr;
                curr = curr.right;
            }else{
                curr = curr.left;
            }
        }

        Node succ = null;
        curr = root;
        while (curr != null){
            if(curr.data > val){
                succ = curr;
                curr = curr.left;
            }else{
                curr = curr.right;
            }
        }

        return new ArrayList<>(Arrays.asList(prec, succ));
    }
}
