package org.example.Backtracking_and_recusion.Recursion;

import java.util.Stack;

public class Sort_A_Stack {
    public static void myStack(Stack<Integer> st){
        if(st.isEmpty()){
            return;
        }
        int temp = st.pop();
        myStack(st);
        insertSort(st, temp);
    }

    public static void insertSort(Stack<Integer> st, int temp){
        if(st.isEmpty() || st.peek() < temp){
            st.push(temp);
            return;
        }
        int ele = st.pop();
        insertSort(st, temp);
        st.push(ele);
    }

    public static void main(String args[]){
        Stack<Integer> st = new Stack<>();
        st.push(3);
        st.push(1);
        st.push(4);
        st.push(2);
        myStack(st);
        System.out.println(st);
    }
}
