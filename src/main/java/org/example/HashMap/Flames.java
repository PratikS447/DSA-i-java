package org.example.HashMap;

import java.util.HashMap;
import java.util.Map;

public class Flames {
    public static String flames(String s1, String s2){
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s1.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        for (char c: s2.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)-1);
        }

        int rem = 0;
        for(int val: map.values()){
            rem += Math.abs(val);
        }

        int val = rem % 6;

        if (val == 1){
            return "Friends";
        } else if (val == 2) {
            return "Love";
        } else if (val == 3) {
            return "Affection";
        } else if (val == 4) {
            return "Marriage";
        } else if (val == 5) {
            return "Enemy";
        }

        return "Siblings";
    }
}
