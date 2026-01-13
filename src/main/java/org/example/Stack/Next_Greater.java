package org.example.Stack;
import java.util.Arrays;
import java.util.Stack;

public class Next_Greater {
    public static int[] next_greater(int arr[]){
        int n = arr.length;
        int result[] = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(result, -1);
        for(int i=n-1; i>0; i--){
            while (!st.isEmpty() && arr[i] > arr[st.peek()]){
                int idx = st.pop();
                result[idx] = arr[i];
            }
            st.push(arr[i]);
        }
        return result;
    }
    public static void main(String args[]){
        int arr[] = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(next_greater(arr)));
    }
}
