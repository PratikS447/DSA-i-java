package org.example.HashMap;

import java.util.HashMap;
import java.util.Map;

public class Longest_substring_with_k_repeating_character {
    public static int longest_string(String s, int k){
        int n = s.length();
        int res = 0;
        for (int maxUnique = 1; maxUnique <= 26; maxUnique++){
            Map<Character, Integer> map = new HashMap<>();
            int left = 0;
            int cnt = 0;
            int distinct = 0;
            for (int right = 0; right < n; right++){
                char cr = s.charAt(right);
                if (!map.containsKey(cr)) distinct++;
                map.put(cr, map.getOrDefault(cr, 0)+1);
                if (map.get(cr) == k) cnt++;

                while (distinct > maxUnique){
                    char cl = s.charAt(left);
                    if (map.get(cl) == k) cnt--;
                    map.put(cl, map.getOrDefault(cl, 0)-1);
                    if(map.get(cl) == 0){
                        distinct--;
                        map.remove(cl);
                    }
                    left++;
                }

                if (distinct == maxUnique && distinct == cnt){
                    res = Math.max(res, right -left +1);
                }
            }
        }
        return res;
    }
}
