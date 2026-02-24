package org.example.Array;

import java.util.HashMap;
import java.util.Map;

public class Count_Subarray_with_given_sum {
    public static int subarraySum(int arr[], int target){
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0, sum = 0;
        map.put(0, 1);
        for(int i = 0; i < arr.length; i++){
            sum = sum + arr[i];
            if(map.containsKey(sum - target)){
                cnt += map.get(sum -target);
            }

            if (map.containsKey(sum)){
                map.put(sum, map.get(sum)+1);
            }
            else{
                map.put(sum , 1);
            }
        }
        return cnt;
    }

    public static void main(String args[]){
        int arr[] = {1, 2, 3};
        System.out.println(subarraySum(arr, 3));
    }
}
