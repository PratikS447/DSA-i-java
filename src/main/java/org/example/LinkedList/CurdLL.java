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
        Node first = head;
        Node second = head.next;

        while (second.next != null){
            first = first.next;
            second = second.next;
        }
        first.next = null;
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

    public static void main(String args[]){
        CurdLL list = new CurdLL();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addFirst(0);
        list.print();
        list.deleteLast();
        list.print();
    }
}
