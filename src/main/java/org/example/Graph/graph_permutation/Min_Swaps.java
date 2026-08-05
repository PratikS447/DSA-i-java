package org.example.Graph.graph_permutation;

public class Min_Swaps {
    public static void min_swaps_in_arr(int arr[], int n){
        int i = 0;
        while(i < n){
            int correct_idx = arr[i] -1;
            if(arr[i] != arr[correct_idx]){
                swap(arr, i, correct_idx);
            }else{
                i++;
            }
        }
    }

    public static void swap(int arr[], int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
