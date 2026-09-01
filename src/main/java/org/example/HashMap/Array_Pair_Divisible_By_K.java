package org.example.HashMap;

import java.util.HashMap;
import java.util.Map;

public class Array_Pair_Divisible_By_K {
    public boolean canArrange(int[] arr, int k){
        Map<Integer, Integer> map = new HashMap<>();
        for (int a: arr){
            int rem = a % k;
            if(rem < 0){
                rem += k;
            }
            map.put(rem, map.getOrDefault(rem, 0)+1);
        }

        if(map.containsKey(0)){
            if(map.get(0) % 2 != 0){
                return false;
            }
        }

        for (int r1 = 1; r1 <= k/2; r1++){
            int r2 = k -r1;
            if(r1 == r2){
                if(map.getOrDefault(r1, 0) % 2 != 0){
                    return false;
                }
            }else {
                int cnt1 = map.getOrDefault(r1, 0);
                int cnt2 = map.getOrDefault(r2, 0);
                if(cnt1 != cnt2){
                    return false;
                }
            }
        }
        return true;
    }
}
