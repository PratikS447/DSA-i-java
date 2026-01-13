package org.example.Sorting;

public class MergeSort {
    public static void divide(int nums[], int s, int e){
        if(s >= e){
            return;
        }
        int mid = s+(e-s)/2;
        divide(nums, s, mid);
        divide(nums, mid+1, e);
    }

    public static void conquer(int nums[], int st, int mid, int ed){

    }
}
