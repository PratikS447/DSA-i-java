package org.example.Sorting;

import java.util.Arrays;

public class insertionSort {
    public static void instSort(int arr[]){
        for(int i = 1; i < arr.length; i++){
            int key = arr[i];
            int j = i-1;
            while( j >= 0 && arr[j] > key){
                arr[j +1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    public static void main(String args[]){
        int arr[] = {4, 1, 3, 9, 7};
        instSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
