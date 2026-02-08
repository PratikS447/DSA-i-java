package org.example.HashMap;

import java.util.HashMap;
import java.util.Map;

public class SumArrayDivisibleByk {
    public static int divisibleByK(int arr[], int k){
        int ans = 0;
        int sum = 0;
        int rem = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < arr.length; i++){
            sum = sum + arr[i];
            rem = sum % k;
            if(rem < 0){
                rem += k;
            }
            if(map.containsKey(rem)){
                ans += map.get(rem);
                map.put(rem, map.get(rem)+1);
            }else{
                map.put(rem, 1);
            }
        }
        return ans;
    }

    public static void main(String args[]){
        int arr[] = {4, 5, 0, -2, -3, 1};
        divisibleByK(arr, 5);
    }
}
