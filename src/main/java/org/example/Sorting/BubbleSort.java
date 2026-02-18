package org.example.Sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void sort(int arr[]){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                if(arr[i] < arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String args[]){
        int arr[] = {1, 4, 3, 7, 2};
        sort(arr);
        System.out.print(Arrays.toString(arr));
    }
}
