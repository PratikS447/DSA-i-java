package org.example.Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void selSort(int arr[]){
        for(int i = 0; i < arr.length; i++){
            int minIdx = i;
            for(int j = i+1; j < arr.length; j++){
                if(arr[minIdx] > arr[j]){
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }
}
