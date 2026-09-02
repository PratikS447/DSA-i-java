package org.example.HashMap;

import java.util.HashMap;
import java.util.Map;

public class Longest_Repeating_Character_Replacement {
    public static int longest_repeating(String s, int k){
        Map<Character, Integer> map = new HashMap<>();
        int window_size = 0;
        int maxLen = 0, left = 0, max = 0;
        for (int right = 0; right < s.length(); right++){
            char cr = s.charAt(right);
            map.put(cr, map.getOrDefault(cr, 0)+1);
            maxLen = Math.max(maxLen, map.get(cr));
            window_size = Math.max(window_size, right -left +1);
            if(window_size -maxLen > k){
                char cl = s.charAt(left);
                map.put(cl, map.getOrDefault(cl, 0)-1);
                left++;
            }
            max = Math.max(max, right -left +1);
        }
        return max;
    }
}
