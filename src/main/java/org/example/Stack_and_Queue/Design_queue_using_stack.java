package org.example.Stack_and_Queue;

import java.util.Stack;

public class Design_queue_using_stack {
    Stack<Integer> st1;
    Stack<Integer> st2;

    public Design_queue_using_stack(){
        this.st1 = new Stack<>();
        this.st2 = new Stack<>();
    }

    public void push(int x){
        st1.push(x);
    }

    public int pop(){
        if(st1.isEmpty()) return -1;

        while (!st1.isEmpty()){
            st2.push(st1.pop());
        }

        int temp = st2.pop();
        while (!st2.isEmpty()){
            st1.push(st2.pop());
        }
        return temp;
    }

    public int peek(){
        if(st1.isEmpty()) return -1;
        while (!st1.isEmpty()){
            st2.push(st1.pop());
        }

        int temp = st2.peek();
        while (!st2.isEmpty()){
            st1.push(st2.pop());
        }
        return temp;
    }

    public boolean isEmpty(){
        if(st1.isEmpty()) return true;
        return false;
    }

}
