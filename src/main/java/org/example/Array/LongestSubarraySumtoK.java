package org.example.Array;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarraySumtoK {
    public static int longest(int arr[], int k){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int max = 0, sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(map.containsKey(sum -k)){
                max = Math.max(max, i - map.get(sum -k));
            }else{
                map.put(sum, i);
            }
        }
        return max;
    }

    public static void main(String args[]){
        int arr[] = {10, 5, 2, 7, 1, 9};
        System.out.println(longest(arr, 15));
    }
}
