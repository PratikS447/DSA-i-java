package org.example.Stack;

import java.util.Stack;

public class Pattern_132 {
    public static boolean pattern_132(int arr[], int n){
        Stack<Integer> st = new Stack<>();
        int num_3 = Integer.MIN_VALUE;
        for (int left = n-1; left >= 0; left--){
            if(arr[left] < num_3){
                return true;
            }
            while (!st.isEmpty() && st.peek() < arr[left]){
                num_3 = st.peek();
                st.pop();
            }
            st.push(arr[left]);
        }
        return false;
    }
    public static void main(String args[]){
        int arr[] = {1, 2, 3, 4};
        System.out.println(pattern_132(arr, 4));
    }
}
