package org.example.LinkedList;

public class Remove_n_node_from_end {
    public void remove_n_node(Node head, int end){
        Node fast = head;
        Node slow = head;
        for(int i = 0; i < end; i++){
            fast = fast.next;
        }

        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
    }
}
