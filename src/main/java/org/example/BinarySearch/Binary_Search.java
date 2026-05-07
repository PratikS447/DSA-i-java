package org.example.BinarySearch;

public class Binary_Search {
    public static int binary(int arr[], int target){
        int i = 0; int j = arr.length -1;
        while (i <= j){
            int mid = i + (j - i) / 2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] > target){
                j = mid -1;
            }else{
                i = mid+1;
            }
        }
        return -1;
    }

    public static void main(String args[]){
        int nums[] = {1, 2, 3, 4, 8, 10};
        System.out.print(binary(nums, 8));
    }
}
