package org.example.Stack;

import java.util.Arrays;
import java.util.Stack;

public class Previous_Smaller_Element {
    public static int[] previous_element_small(int arr[], int n){
        Stack<Integer> stack = new Stack<>();
        int pse[] = new int[arr.length];
        Arrays.fill(pse, -1);
        for (int left = n -1; left >= 0; left--){
            while (!stack.isEmpty() && arr[stack.peek()] > arr[left]){
                pse[stack.pop()] = arr[left];
            }
            stack.push(left);
        }
        return pse;
    }
    public static void main(String args[]){
        int arr[] = {4, 5, 2, 10, 8};
        System.out.println(Arrays.toString(previous_element_small(arr, arr.length)));
        // Correct Expected Output: [-1, 4, -1, 2, 2]
    }
}
