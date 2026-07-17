package org.example.TwoPointer_SlidingWindow;

public class Max_Width_Ramp {
    public static int max_ramp(int[] nums){
        int suffix[] = suffix(nums);
        int max = Integer.MIN_VALUE;
        int i = 0, j = 0, n = nums.length;
        while (i < n && j < n){
            if(nums[i] <= suffix[j]){
                max = Math.max(max, j -i);
                j++;
            }else{
                i++;
            }
        }
        return max;
    }

    public static int[] suffix(int nums[]){
        int max = Integer.MIN_VALUE;
        int ans[] = new int[nums.length];
        for (int i = nums.length -1; i >= 0; i--){
            max = Math.max(max, nums[i]);
            ans[i] = max;
        }
        return ans;
    }
}
