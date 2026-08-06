package org.example.Greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Avoid_Flood_City {
    public static int[] avoid_flood(int arr[]){
        int ans[] = new int[arr.length];
        Map<Integer, Integer> full_lake = new HashMap<>();
        TreeSet<Integer> dry_day = new TreeSet<>();
        for (int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                dry_day.add(i);
                ans[i] = 1;
            }else{
                int lake = arr[i];
                if(full_lake.containsKey(lake)){
                    int last_dry_day = full_lake.get(lake);
                    Integer chosen_dry_day = dry_day.ceiling(last_dry_day);
                    if(chosen_dry_day == null){
                        return new int[0];
                    }
                    ans[chosen_dry_day] = lake;
                    dry_day.remove(chosen_dry_day);
                }
                full_lake.put(lake, i);
                ans[i] = -1;
            }
        }
        return ans;
    }
}
