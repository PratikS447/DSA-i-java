package org.example.TwoPointer_SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class Fruits_into_basket {
    public static int totalFruit(int[] fruits) {
        int left = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(int right = 0; right < fruits.length; right++){
            int curr_right = fruits[right];
            map.put(curr_right, map.getOrDefault(curr_right, 0)+1);
            if(map.size() > 2){
                int curr_left = fruits[left];
                map.put(curr_left, map.getOrDefault(curr_left, 0)-1);
                if(map.get(curr_left) == 0){
                    map.remove(curr_left);
                }
                left++;
            }
            max = Math.max(max, right -left +1);
        }
        return max;
    }
}
