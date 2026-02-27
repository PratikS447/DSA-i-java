package org.example.HashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Two_Sum {
    public static int[] sum(int [] arr, int target){
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

    public static void main(String args[]){
        int arr[] = {3,3};
        System.out.println(Arrays.toString(sum(arr, 6)));
    }
}
