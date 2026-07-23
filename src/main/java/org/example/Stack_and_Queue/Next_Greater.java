package org.example.Stack_and_Queue;
import java.util.Arrays;
import java.util.Stack;

public class Next_Greater {
    public static int[] next_greater(int arr[]){
        int n = arr.length;
        int result[] = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(result, -1);
        for(int i = 0; i < arr.length; i++){
            while (!st.isEmpty() && arr[i] > arr[st.peek()]){
                result[st.pop()] = arr[i];
            }
            st.push(i);
        }
        return result;
    }
    public static void main(String args[]){
        int arr[] = {1, 3, 2, 4};
        System.out.println(Arrays.toString(next_greater(arr)));
    }
}
