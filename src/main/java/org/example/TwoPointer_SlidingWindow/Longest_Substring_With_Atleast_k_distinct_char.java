package org.example.TwoPointer_SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class Longest_Substring_With_Atleast_k_distinct_char {
    public static int longest_subtring(String str, int k){
        int n = str.length();
        int res = 0;

        for (int maxLen = 1; maxLen <= 26; maxLen++){
            int left = 0;
            Map<Character, Integer> map = new HashMap<>();
            int distinct = 0;
            int count_Atleast_k = 0;

            for (int right = 0; right < str.length(); right++){
                char cr = str.charAt(right);
                if (map.getOrDefault(cr, 0) == 0) distinct++;
                map.put(cr, map.getOrDefault(cr, 0)+1);
                if (map.get(cr) == k) count_Atleast_k++;

                while (distinct > maxLen){
                    char cl = str.charAt(left);
                    if (map.get(cl) == k) count_Atleast_k--;
                    map.put(cl, map.getOrDefault(cl, 0)-1);
                    if (map.get(cl) == 0) distinct--;
                    left++;
                }

                if (distinct == maxLen && distinct == count_Atleast_k){
                    res = Math.max(res, right -left +1);
                }
            }
        }
        return res;
    }
}
