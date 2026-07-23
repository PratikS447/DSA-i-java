package org.example.Stack_and_Queue;

import java.util.Arrays;
import java.util.Stack;

public class Largest_Histogram_Area {
    public static int larg_histo_area(int arr[], int n){
        int nse[] = new int[arr.length];
        Stack<Integer> st_nse = new Stack<>();
        Arrays.fill(nse, n);
        for (int right = 0; right < arr.length; right++){
            while (!st_nse.isEmpty() && arr[st_nse.peek()] > arr[right]){
                nse[st_nse.pop()] = right;
            }
            st_nse.push(right);
        }

        int pse[] = new int[arr.length];
        Stack<Integer> st_pse = new Stack<>();
        Arrays.fill(pse, -1);
        for (int left = n-1; left >= 0; left--){
            while (!st_pse.isEmpty() && arr[st_pse.peek()] > arr[left]){
                pse[st_pse.pop()] = left;
            }
            st_pse.push(left);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++){
            int width = nse[i] -pse[i] -1;
            int area = width*arr[i];
            max = Math.max(max, area);
        }
        return max;
    }

    public static void main(String args[]){
        int arr[] = {2, 1, 5, 6, 2, 3};
        System.out.println("Max Area: " + larg_histo_area(arr, arr.length)); // Expected: 10
    }
}
