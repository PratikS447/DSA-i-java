package org.example.Tree.Binary_Search_Tree;

public class Serialization_and_Deserialization {
    public static String Serialization(Node root){
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    public static void preorder(Node root, StringBuilder sb){
        if(root == null){
            sb.append('#').append(',');
            return;
        }
        sb.append(root.data).append(',');
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    static int idx;
    public static Node deserialization(String data){
        String str[] = data.split(",");
        idx = 0;
        return preorder_builder(str);
    }

    public static Node preorder_builder(String arr[]){
        if(idx == arr.length || arr[idx].equals("#")){
            idx++;
            return null;
        }
        Node curr = new Node(Integer.parseInt(arr[idx++]));
        curr.left = preorder_builder(arr);
        curr.right = preorder_builder(arr);

        return curr;
    }
}
