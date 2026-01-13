package org.example.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Two_sum {
    public static int[] method(int [] arr, int target){
        int [] ans = new int[2];
        for(int i=0; i<arr.length-1; i++){
            for (int j=i+1; j<arr.length; j++){
                if(arr[i] + arr[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
    public static int[] method_2(int [] arr, int target){
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i=0; i<arr.length; i++){
            int complement = target - arr[i];
            if(hm.containsKey(complement)){
                return new int[]{hm.get(complement), i};
            }else{
                hm.put(arr[i], i);
            }
        }
        return new int[]{-1, -1};
    }
    public static int[] max_min(int [] arr){
        int min = arr[0]; int max = arr[0];
        for (int i=0; i<arr.length; i++){
            min = Math.min(min, arr[i]);
        }
        for (int i=0; i<arr.length; i++){
            max = Math.max(arr[i], max);
        }
        return new int[]{min, max};
    }
    public static boolean Array_sorted(int arr[]){
        if(arr.length == 0 || arr.length == 1){
            return true;
        }
        for (int i=0; i< arr.length-1; i++){
            if(arr[i] > arr[i+1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]){
        int [] arr1 = {1, 3, 2, 4};
        System.out.println(Array_sorted(arr1));
    }
}
