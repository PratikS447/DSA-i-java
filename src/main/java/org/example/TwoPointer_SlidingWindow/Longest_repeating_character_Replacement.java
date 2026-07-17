package org.example.TwoPointer_SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class Longest_repeating_character_Replacement {
    public static int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0; int wind = 0;
        int max_freq = 0;
        int maxLen = 0;
        for(int right = 0; right < s.length(); right++){
            char curr_right = s.charAt(right);
            map.put(curr_right, map.getOrDefault(curr_right, 0)+1);
            max_freq = Math.max(max_freq, map.get(curr_right));
            wind = right -left + 1;
            if(wind - max_freq > k){
                char curr_left = s.charAt(left);
                map.put(curr_left, map.getOrDefault(curr_left, 0)-1);
                left++;
            }
            maxLen = Math.max(maxLen, right -left +1);
        }
        return maxLen;
    }
}
