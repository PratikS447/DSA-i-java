package org.example.Array;

import java.util.Arrays;

public class CountFreq {
    public static int freq(int nums[]){
        Arrays.sort(nums);

        int maxEle = -1;
        int maxFreq = Integer.MIN_VALUE;

        int currEle = nums[0];
        int currFreq = 1;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i-1]){
                if(currFreq >= maxFreq){
                    maxEle = currEle;
                    maxFreq = currFreq;
                }
                currEle = nums[i];
                currFreq = 1;
            }else{
                currFreq++;
            }
        }
        if(currFreq > maxFreq){
            maxEle = currEle;
            maxFreq = currFreq;
        }
        return maxEle;
    }

    public static void main(String args[]){
        int nums[] = {7, 7, 6, 4, 8, 7, 3, 1};
        System.out.println(freq(nums));
    }
}
