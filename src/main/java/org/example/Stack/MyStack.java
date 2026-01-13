package org.example.Stack;

import java.util.Map;

public class MyStack {
    int top;
    int arr[];
    int size;
    MyStack(int size){
        this.size = size;
        arr = new int[size];
        top = -1;
    }

//    Push the data into the stack
    public void push(int data){
        if(top == size - 1){
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top] = data;
        System.out.println(data + " pushed");
    }

//    Pop the data
    public int pop(){
        if(top == -1){
            System.out.println("Stack is Empty");
        }
        int val = arr[top--];
        return val;
    }
//    is Empty
    public boolean isEmpty(){
        if (top == -1){
            return true;
        }
        return false;
    }
//    Peek value
    public int peek(){
        if(top == -1){
            return -1;
        }
        return arr[top];
    }
    public static void main(String args[]){
        MyStack myStack = new MyStack(5);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.pop();
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());
    }
}
