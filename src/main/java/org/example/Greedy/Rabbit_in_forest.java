package org.example.Greedy;

import java.util.HashMap;
import java.util.Map;

public class Rabbit_in_forest {
    public static int in_forest(int arr[]){
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int a: arr){
            map.put(a, map.getOrDefault(a, 0)+1);
        }
        int total = 0;
        for (int key: map.keySet()){
            int freq = map.get(key);
            int group = key +1;
            int group_need = (int)Math.ceil((double) freq/group);
            total += group*group_need;
        }
        return total;
    }
}
