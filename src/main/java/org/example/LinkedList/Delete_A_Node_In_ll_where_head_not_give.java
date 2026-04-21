package org.example.LinkedList;

public class Delete_A_Node_In_ll_where_head_not_give {
    public void delete(Node node){
        node.data = node.next.data;
        node.next = node.next.next;
    }
}
