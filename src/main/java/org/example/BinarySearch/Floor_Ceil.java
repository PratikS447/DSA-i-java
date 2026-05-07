package org.example.BinarySearch;

import java.util.ArrayList;

public class Floor_Ceil {
    public static ArrayList<Integer> floor_ans_ceil(int nums[], int target){
        ArrayList<Integer> ls = new ArrayList<>();
        int i = 0, j = nums.length -1, ans = -1;
        while (i <= j){
            int mid = i + (j - i) / 2;
            if(nums[mid] == target){
                ans = mid;
                j = mid -1;
            } else if (nums[mid] > target) {
                j = mid -1;
            }else{
                i = mid + 1;
            }
        }
        ls.add(ans);

        i = 0; j = nums.length -1; ans = -1;
        while (i <= j){
            int mid = i + (j - i) / 2;
            if(nums[mid] == target){
                ans = mid;
                i = mid +1;
            } else if (nums[mid] > target) {
                j = mid -1;
            }else{
                i = mid + 1;
            }
        }
        ls.add(ans);

        return ls;
    }

    public static void main(String args[]){
        int nums[] = {1, 2, 3};
        System.out.println(floor_ans_ceil(nums, 4));
    }
}
