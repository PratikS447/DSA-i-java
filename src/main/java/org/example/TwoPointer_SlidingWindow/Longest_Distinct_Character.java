package org.example.TwoPointer_SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class Longest_Distinct_Character {
    public static int longest(String str){
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, maxLen = 0;
        for (int right = 0; right < str.length(); right++){
            char curr = str.charAt(right);
            map.put(curr, map.getOrDefault(curr, 0)+1);
            while (map.get(curr) > 1){
                char curr_left = str.charAt(left);
                map.put(curr_left, map.getOrDefault(curr_left, 0)-1);
                if(map.get(curr_left) == 0){
                    map.remove(curr_left);
                }
                left++;
            }
            maxLen = Math.max(maxLen, right -left +1);
        }
        return maxLen;
    }
}