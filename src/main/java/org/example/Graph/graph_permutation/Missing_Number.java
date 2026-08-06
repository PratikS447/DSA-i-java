package org.example.Graph.graph_permutation;

public class Missing_Number {
    public static int missing_num(int arr[]){
        int i = 0, n = arr.length;
        while (i < n){
            int corr_idx = arr[i];
            if(arr[i] < n && arr[i] != arr[corr_idx]){
                swap(arr, i, corr_idx);
            }else {
                i++;
            }
        }
        for (int idx = 0; idx < n; idx++){
            if(arr[idx] != idx){
                return idx;
            }
        }
        return n;
    }

    public static void swap(int arr[], int idx_1, int idx_2){
        int temp = arr[idx_1];
        arr[idx_1] = arr[idx_2];
        arr[idx_2] = temp;
    }
}
