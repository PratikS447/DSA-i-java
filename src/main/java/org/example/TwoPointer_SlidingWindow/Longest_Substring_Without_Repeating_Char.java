package org.example.TwoPointer_SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class Longest_Substring_Without_Repeating_Char {
    public static int length_of_character(String s){
        int left = 0; int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++){
            char curr_right = s.charAt(right);
            if(map.containsKey(curr_right)){
                left = Math.max(left, map.get(curr_right)+1);
            }
            map.put(curr_right, right);
            max = Math.max(max, right -left +1);
        }
        return max;
    }
}
