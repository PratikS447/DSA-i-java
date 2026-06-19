package org.example.Stack;

import java.util.Arrays;
import java.util.Stack;

public class Stock_Span {
    public static int[] span_stock(int arr[]){
        Stack<Integer> st = new Stack<>();
        int span[] = new int[arr.length];
        for(int right = 0; right < arr.length; right++){
            while(!st.isEmpty() && arr[st.peek()] <= arr[right]){
                st.pop();
            }
            if(st.isEmpty()) span[right] = right + 1;
            else span[right] = right - st.peek();
            st.push(right);
        }
        return span;
    }
    public static void main(String args[]){
        int arr[] = {100, 80, 60, 70, 60, 75, 85};
        System.out.println(Arrays.toString(span_stock(arr)));
    }
}
