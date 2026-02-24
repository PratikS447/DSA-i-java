package org.example.Array;

import java.util.HashMap;
import java.util.Map;

public class Subarray_Sum_To_0 {
    public static int sum(int arr[]){
        Map<Integer, Integer> mp = new HashMap<>();
        int sum = 0, max = 0;
        for(int i = 0; i < arr.length; i++){
            sum = sum + arr[i];
            if(sum == 0){
                max = max + 1;
            }
            else if(mp.containsKey(sum)){
                max = Math.max(max, i - mp.get(sum));
            }else{
                mp.put(sum, i);
            }
        }

        return max;
    }

    public static void main(String args[]){
        int arr[] = {2, 10, 4};
        System.out.println(sum(arr));
    }
}
