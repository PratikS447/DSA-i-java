package org.example.HashMap;

import java.util.HashMap;
import java.util.Map;

public class Count_Subarray_With_Give_Xor {
    public static int count_Xor(int arr[], int k){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int xor_Sum = 0, cnt = 0;
        for (int i = 0; i < arr.length; i++){
            xor_Sum ^= arr[i];
            if (map.containsKey(xor_Sum^k)){
                cnt += map.get(xor_Sum^k);
            }

            if (map.containsKey(xor_Sum)){
                map.put(xor_Sum, map.get(xor_Sum)+1);
            }else{
                map.put(xor_Sum, 1);
            }
        }
        return cnt;
    }

    public static void main(String args[]){
        int arr[] = {1, 1, 1, 1};
        System.out.println(count_Xor(arr, 0));
    }
}
