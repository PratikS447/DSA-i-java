package org.example.Sorting;

import java.util.Arrays;

public class QuickSort {
    public static void quiSort(int arr[], int low, int high){
        if(low < high){
            int pi = partition(arr, low, high);
            quiSort(arr, low, pi -1);
            quiSort(arr, pi+1, high);
        }
    }

    public static int partition(int arr[], int low, int high){
        int pivot = arr[high];
        int i = low -1;

        for (int j = low; j < high; j++){
            if(arr[j] <= pivot){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);

        return i+1;
    }

    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String args[]){
        int arr[] = {4, 1, 3, 9, 7};
        quiSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
