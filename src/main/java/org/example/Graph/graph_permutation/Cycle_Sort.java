package org.example.Graph.graph_permutation;

public class Cycle_Sort {
    public static void sort(int arr[]){
        int i = 0;
        int n = arr.length;
        while (i < n){
            int correct_idx = arr[i] -1;
            if (correct_idx != i){
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
