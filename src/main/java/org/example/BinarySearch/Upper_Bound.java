package org.example.BinarySearch;

public class Upper_Bound {
    public static int upper_b(int nums[], int target){
        int i = 0, j = nums.length -1;
        int ans = nums.length;
        while (i <= j){
            int mid = i + (j - i) / 2;
            if(nums[mid] > target){
                ans = mid;
                j = mid - 1;
            }else{
                i = mid+1;
            }
        }
        return ans;
    }
    public static void main(String args[]){
        int nums[] = {2, 3, 7, 10, 11, 11, 25};
        int target = 9;
        System.out.println(upper_b(nums, target));
    }
}
