package org.example.HashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Divide_Array_In_K_Consecutive_Numbers {
    public boolean isPossibleDivide(int[] nums, int k) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        for(int right = 0; right < nums.length; right++){
            int curr = nums[right];
            int cnt = k;
            if(!map.containsKey(curr)){
                continue;
            }

            while(map.containsKey(curr) && cnt != 0){
                map.put(curr, map.getOrDefault(curr, 0)-1);
                if(map.get(curr) == 0){
                    map.remove(curr);
                }
                curr = curr +1;
                cnt--;
            }

            if(cnt != 0){
                return false;
            }
        }

        return map.isEmpty();
    }
}
