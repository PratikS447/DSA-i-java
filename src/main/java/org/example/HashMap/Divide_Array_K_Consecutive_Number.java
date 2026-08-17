package org.example.HashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Divide_Array_K_Consecutive_Number {
    public boolean isPossibleDivide(int[] nums, int k){
        if (nums.length % k != 0) return false;
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        for (int i = 0; i < nums.length; i++){
            int curr = nums[i];
            if(!map.containsKey(curr)) continue;
            int cnt = k;
            while (map.containsKey(curr) && cnt != 0){
                map.put(curr, map.getOrDefault(curr, 0)-1);
                if(map.get(curr) == 0){
                    map.remove(curr);
                }
                cnt--;
                curr = curr+1;
            }
            if(cnt != 0){
                return false;
            }
        }

        return map.isEmpty();
    }
}
