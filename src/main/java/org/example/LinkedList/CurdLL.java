package org.example.LinkedList;

public class CurdLL {
    Node head;

    // Add at beginning
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Add at end
    public void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    // At specific position
    public void specificPosition(Node node, int pos){
        if(pos == 0){
            node.next = head;
            head = node;
            return;
        }
        Node curr = head;
        int cnt = 1;
        while(curr != null && cnt < pos -1){
            cnt++;
            curr = curr.next;
        }

        node.next = curr.next;
        curr.next = node;
    }

    // Delete first node
    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;
    }

    // Delete last node
    public void deleteLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node curr = head;
        while (curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = null;
    }

    // Print list
    public void print() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Reverse list
    public void reverse() {
        Node prev = null;
        Node curr = head;
        Node nextNode;

        while (curr != null) {
            nextNode = curr.next;
            curr.next = prev;

            prev = curr;
            curr = nextNode;
        }
        head = prev;
    }

    public static void main(String args[]) {
        CurdLL list = new CurdLL();

        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addFirst(0);

        System.out.println("Original List:");
        list.print();

        list.deleteFirst();
        System.out.println("After deleteFirst:");
        list.print();

        list.deleteLast();
        System.out.println("After deleteLast:");
        list.print();

        list.reverse();
        System.out.println("After reverse:");
        list.print();

        System.out.println("Merge the two sorted Linked List");
        CurdLL curr = new CurdLL();
        curr.addLast(1);
        curr.addLast(2);
        curr.addLast(3);
        curr.addLast(4);
        curr.addLast(5);

        CurdLL curr2 = new CurdLL();
        curr2.addLast(6);
        curr2.addLast(7);
        curr2.addLast(8);
        curr2.addLast(9);
        curr2.addLast(10);

        Merge_Linked_List mergeLinkedList = new Merge_Linked_List();
        Node merge_ll = mergeLinkedList.merge_ll(curr.head, curr2.head);
        mergeLinkedList.print_Merge(merge_ll);
    }
}