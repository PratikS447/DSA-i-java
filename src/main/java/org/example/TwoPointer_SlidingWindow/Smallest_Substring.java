package org.example.TwoPointer_SlidingWindow;

import java.util.*;

public class Smallest_Substring {
    public static List<Integer> smallestSubarrayWithKDistinct(List<Integer> a, int k){
        // 1. Defend against invalid inputs or edge cases
        if (k > a.size() || k <= 0) {
            return List.of(-1);
        }

        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int min_len = Integer.MAX_VALUE;
        int start = -1;
        int end = -1;

        for(int right = 0; right < a.size(); right++){
            int curr = a.get(right);
            map.put(curr, map.getOrDefault(curr, 0) + 1);

            // 2. CRITICAL FIX: Squeeze using 'left' index element, NOT 'curr' value
            while (map.size() > k || (map.size() == k && map.getOrDefault(a.get(left), 0) > 1)){
                int left_element = a.get(left);

                map.put(left_element, map.get(left_element) - 1);
                if(map.get(left_element) == 0){
                    map.remove(left_element);
                }
                left++;
            }

            // 3. Capture the tightest window bounds for this distinct count
            if(map.size() == k){
                int currLen = right - left + 1;
                if(currLen < min_len){
                    min_len = currLen;
                    start = left;
                    end = right;
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        if(start == -1){
            res.add(-1);
        } else {
            res.add(start);
            res.add(end);
        }
        return res;
    }
}