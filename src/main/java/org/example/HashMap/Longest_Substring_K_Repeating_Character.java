package org.example.HashMap;

import java.util.HashMap;
import java.util.Map;

public class Longest_Substring_K_Repeating_Character {
    public static int longest_substring(String str, int k){
        return helper(str, 0, str.length(), k);
    }

    public static int helper(String str, int st, int ed, int k){
        if(ed - st < k) return 0;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = st; i < ed; i++){
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0)+1);
        }

        for (int i = st; i < ed; i++){
            if(map.get(str.charAt(i)) < k){
                int left = helper(str, st, i, k);
                int right = helper(str, i+1, ed, k);
                return Math.max(left, right);
            }
        }

        return ed -st;
    }
}
