package org.example.BinarySearch;

public class Search_Insert {
    public static int searchInsert(int nums[], int target){
        int i = 0; int j = nums.length -1; int ans = nums.length;
        while(i <= j){
            int mid = i + (j - i)/2;
            if(nums[mid] == target){
                ans = mid;
                j = mid -1;
            }else{
                i = mid +1;
            }
        }
        return ans;
    }
    public static void main(String args[]){
        int nums[] = {1,3,5,6};
        System.out.println(searchInsert(nums, 5));
    }
}
