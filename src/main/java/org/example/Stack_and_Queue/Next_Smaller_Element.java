package org.example.Stack_and_Queue;

import java.util.Arrays;
import java.util.Stack;

public class Next_Smaller_Element {
    public static int[] next_smaller_ele(int arr[]){
        Stack<Integer> stack = new Stack<>();
        int nse[] = new int[arr.length];
        Arrays.fill(nse, -1);
        for (int right = 0; right < arr.length; right++){
            while (!stack.isEmpty() && arr[stack.peek()] > arr[right]){
                nse[stack.pop()] = arr[right];
            }
            stack.push(right);
        }
        return nse;
    }

    public static void main(String args[]){
        int arr[] = {4, 5, 2, 10, 8};
        System.out.println(Arrays.toString(next_smaller_ele(arr)));
        // Correct Expected Output: [2, 2, -1, 8, -1]
    }
}
