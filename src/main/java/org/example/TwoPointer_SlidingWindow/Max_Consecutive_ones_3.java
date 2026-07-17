package org.example.TwoPointer_SlidingWindow;

public class Max_Consecutive_ones_3 {
    public static int consecutive_one(int arr[], int k){
        int left = 0;
        int max = 0;
        for(int right = 0; right < arr.length; right++){
            if(arr[right] == 0){
                k--;
            }
            if(k < 0){
                if(arr[left] == 0){
                    k++;
                }
                left++;
            }
            max = Math.max(max, right -left +1);
        }
        return max;
    }
}
