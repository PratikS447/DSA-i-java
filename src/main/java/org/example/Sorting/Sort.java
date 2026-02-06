package org.example.Sorting;

import java.util.Arrays;

public class Sort {
    public static int[] sort(int arr[]){
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
    public static void main(String args[]){
        int arr [] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(sort(arr)));
    }
}
