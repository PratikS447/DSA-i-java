package org.example.HashMap;

import java.util.HashMap;
import java.util.Map;

public class Minimum_Window_substring {
    public static String min_Window(String s, String t){
        Map<Character, Integer> t_map = new HashMap<>();
        for(char c: t.toCharArray()){
            t_map.put(c, t_map.getOrDefault(c, 0)+1);
        }
        int left = 0, req = t.length(), min = Integer.MAX_VALUE, start = 0;
        for(int right = 0; right < s.length(); right++){
            char curr = s.charAt(right);
            if(t_map.containsKey(curr)){
                int val = t_map.get(curr);
                if(val > 0){
                    req--;
                }
                t_map.put(curr, t_map.getOrDefault(curr, 0)-1);
            }

            while (req == 0){
                if(right - left + 1 < min){
                    min = right -left +1;
                    start = left;
                }
                char left_curr = s.charAt(left);
                if(t_map.containsKey(left_curr)){
                    int val = t_map.get(left_curr);
                    if(val == 0){
                        req++;
                    }
                    t_map.put(left_curr, t_map.getOrDefault(left_curr, 0)+1);
                }
                left++;
            }
        }
        return s.substring(start, start+min);
    }
    public static void main(String args[]){
        System.out.println(min_Window("ADOBECODEBANC", "ABC"));
    }
}
