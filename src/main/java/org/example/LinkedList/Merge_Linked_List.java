package org.example.LinkedList;

public class Merge_Linked_List {
    public Node merge_ll(Node head1, Node head2){
        Node dummy = new Node(-1);
        Node temp = dummy;

        Node curr1 = head1;
        Node curr2 = head2;

        while(curr1 != null && curr2 != null){
            if(curr1.data < curr2.data){
                temp.next = curr1;
                curr1 = curr1.next;
            }else{
                temp.next = curr2;
                curr2 = curr2.next;
            }
            temp = temp.next;
        }

        if(curr1 != null){
            temp.next = curr1;
        }

        if(curr2 != null){
            temp.next = curr2;
        }

        return dummy.next;
    }

    public void print_Merge(Node head){
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
    }
}
