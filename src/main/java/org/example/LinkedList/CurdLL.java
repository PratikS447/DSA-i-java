package org.example.LinkedList;

public class CurdLL {
    Node head;
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void addFirst(int data){
       Node newNode = new Node(data);
       if(newNode == null){
           head = newNode;
           return;
       }
       newNode.next = head;
       head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        if(newNode == null){
            head = newNode;
            return;
        }
        Node curr = head;
        while (curr.next != null){
            curr = curr.next;
        }
        curr.next = newNode;
    }

    public void deleteFirst(){
        head = head.next;
    }

    public void deleteLast(){
        // Case 1: List is empty
        if (head == null) {
            System.out.println("List is already empty.");
            return;
        }

        // Case 2: List has only one node
        if (head.next == null) {
            head = null;
            return;
        }

        // Case 3: List has 2+ nodes
        Node curr = head;
        while (curr.next.next != null) { // Look two steps ahead
            curr = curr.next;
        }
        // Now curr is the second-to-last node
        curr.next = null;
    }

    public void print(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }

    // Reverse the Linked List
    public void reverse(){
        Node prev = null;
        Node curr = head;
        Node nextNode = null;

        while (curr != null){
            nextNode = curr.next;
            curr.next = prev;

            prev = curr;
            curr = nextNode;
        }
        head = prev;
    }

    public static void main(String args[]){
        CurdLL list = new CurdLL();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addFirst(0);
        list.print();
//        list.deleteLast();
        list.reverse();
        list.print();
    }
}
