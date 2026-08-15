package org.example.Sorting;

import java.util.Arrays;

public class Sort {
    public static int[] selectionSort(int arr[]){
        for (int i = 0; i < arr.length-1; i++){
            int min_value = i;
            for (int j = i + 1; j < arr.length; j++){
                if(arr[min_value] > arr[j]){
                    min_value = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min_value];
            arr[min_value] = temp;
        }
        return arr;
    }

    public static int[] bubbleSort(int arr[]){
        for (int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                if(arr[i] < arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static int[] insertion(int arr[]){
        for(int i = 1; i < arr.length; i++){
            int key = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
        return arr;
    }

}
