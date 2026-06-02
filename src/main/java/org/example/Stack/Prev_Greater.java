package org.example.Stack;

import java.util.Arrays;
import java.util.Stack;

public class Prev_Greater {
    public static int[] prev_greater_element(int arr[]){
        Stack<Integer> st = new Stack<>();
        int pge[] = new int[arr.length];
        Arrays.fill(pge, -1);
        for(int left = arr.length -1; left >= 0; left--){
            while (!st.empty() && arr[st.peek()] < arr[left]){
                pge[st.pop()] = arr[left];
            }
            st.push(left);
        }
        return pge;
    }

    public static void main(String args[]){
        int arr[] = {4, 5, 2, 10, 8};
        System.out.println(Arrays.toString(prev_greater_element(arr)));
    }
}
