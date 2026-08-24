package org.example.Backtracking_and_recusion.Recursion;

public class BinarySearch {
    public static int mySearch(int arr[], int start, int end,int target){
        if(start > end){
            return -1;
        }

        int mid = start + (end - start)/2;

        if(arr[mid] == target){
            return mid;
        }
        if(arr[mid] < target){
            return mySearch(arr, mid + 1, end, target);
        }
        return mySearch(arr, start, mid -1, target);
    }

    public static void main(String args[]){
        int arr[] = {1,2,3,4,5,6,7,8,9};
        System.out.println(mySearch(arr, 0, arr.length -1, 7));
    }
}
