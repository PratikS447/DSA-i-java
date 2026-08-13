package org.example.Graph.graph_permutation;

public class Roll_Number {
    public static int[] find_repeating_and_missing_number(int nums[]){
        int i = 0, n = nums.length;
        while(i < n){
            int correct_idx = nums[i] -1;
            if(nums[i] != nums[correct_idx]){
                swap(nums, i, correct_idx);
            }else{
                i++;
            }
        }

        for (int idx = 0; idx < n; idx++){
            if(nums[idx] != idx+1){
                return new int[]{nums[idx], idx+1};
            }
        }

        return new int[]{-1, -1};
    }

    public static void swap(int nums[], int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
