package org.example.Array;

import java.util.Map;
import java.util.TreeMap;

public class Subarray_sum_divisible_by_k {
    public static int divisible_k(int arr[], int k){
        Map<Integer, Integer> mp = new TreeMap<>();
        mp.put(0, 1);
        int sum = 0, rem = 0, ans = 0;
        for (int i = 0; i < arr.length; i++){
            sum = sum + arr[i];
            rem = sum % k;

            if(rem < 0){
                rem = rem + k;
            }
            if(mp.containsKey(rem)){
                ans = ans + mp.get(rem);
                mp.put(rem, mp.get(rem)+1);
            }else{
                mp.put(rem, 1);
            }
        }
        return ans;
    }

    public static void main(String args[]){
        int arr[] = {4, 5, 0, -2, -3, 1};
        System.out.print(divisible_k(arr, 5));
    }
}
