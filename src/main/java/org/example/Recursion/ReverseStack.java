package org.example.Recursion;

import java.util.Stack;

public class ReverseStack {
    public static void myReverse(Stack<Integer> st){
        if(st.isEmpty()){
            return;
        }
        int temp = st.pop();
        myReverse(st);
        insertionSort(st, temp);
    }

    public static void insertionSort(Stack<Integer> st, int temp){
        if(st.isEmpty()){
            st.push(temp);
            return;
        }
        int ele = st.pop();
        insertionSort(st, temp);
        st.push(ele);
    }
    public static void main(String args[]){
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);

        myReverse(st);
        System.out.println(st);
    }
}
