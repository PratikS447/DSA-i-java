package org.example.LinkedList;

public class Reverse_Nodes_in_k_Group {
    public Node reverseKGroup(Node head, int k) {
        Node temp = head; int cnt = 0;
        while(cnt < k && temp != null){
            cnt++;
            temp = temp.next;
        }

        Node prev = reverseKGroup(temp, k);
        temp = head;
        cnt = 0;
        while(cnt < k){
            Node next = temp.next;
            temp.next = prev;

            prev = temp;
            temp = next;

            cnt++;
        }

        return prev;
    }
}
