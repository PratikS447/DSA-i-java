package org.example.Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void usingMerge(int arr[], int left, int right){
        if(left < right){
            int mid = left +(right - left)/2;
            usingMerge(arr, left, mid);
            usingMerge(arr, mid+1, right);
            merge(arr, left, right, mid);
        }
    }

    public static void merge(int arr[], int left, int right, int mid){
        int res[] = new int[right -left +1];
        int i = left, j = mid+1, k = 0;
        while(i <= mid && j <= right){
            if(arr[i] <= arr[j]){
                res[k] = arr[i];
                i++;
            }else{
                res[k] = arr[j];
                j++;
            }
            k++;
        }

        while(i <= mid){
            res[k++] = arr[i++];
        }
        while(j <= right){
            res[k++] = arr[j++];
        }

        for(int l = 0; l < res.length; l++){
            arr[left+l] = res[l];
        }

    }
}
