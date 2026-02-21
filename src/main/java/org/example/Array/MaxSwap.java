package org.example.Array;

import java.util.Arrays;

public class MaxSwap {
    public static String swaps(int arr[], int n, int x){
        if(x <= n/2){
            return "YES";
        }
        int sorted[] = arr.clone();
        Arrays.sort(sorted);
        for (int i = 0; i < arr.length; i++){
            if(sorted[i] != arr[i]){
                if((i-1 < x) && (n -i < x)){
                    return "NO";
                }
            }
        }
        return "YES";
    }

    public static void main(String args[]){
        int arr[] = {3, 2, 1};
        System.out.println(swaps(arr, 3, 3));
    }
}
