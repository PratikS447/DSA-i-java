package org.example.Array;

import java.util.Arrays;

public class Rotate_Arr {
    public static void reverse(int arr[], int i, int j){

        while (i <= j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++; j--;
        }
    }

    public static int[] rotate_k(int arr[], int k){
        k = k % arr.length;
        reverse(arr, 0, arr.length-1);
        reverse(arr, 0, k-1);
        reverse(arr,  k, arr.length-1);

        return arr;
    }

    public static void main(String args[]){
        int [] arr = {1,2,3,4,5,6,7};
        int [] arr1 = rotate_k(arr, 3);
        System.out.print(Arrays.toString(arr1));
    }
}
