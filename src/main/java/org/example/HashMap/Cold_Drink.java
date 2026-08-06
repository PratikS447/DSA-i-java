package org.example.HashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Cold_Drink {
    public static int[] drinks(int arr[], int k){
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int ans[] = new int[2];
        ans[0] = -1; ans[1] = -1;
        for (int right = 0; right < arr.length; right++){
            int curr_right = arr[right];
            map.put(curr_right, map.getOrDefault(curr_right, 0)+1);
            while (map.size() == k){
                if(minLen > right -left +1){
                    minLen = right -left + 1;
                    ans[0] = left;
                    ans[1] = right;
                }
                int curr_left = arr[left];
                map.put(curr_left, map.getOrDefault(curr_left, 0)-1);
                if(map.get(curr_left) == 0){
                    map.remove(curr_left);
                }
                left++;
            }
        }
        if (ans[0] == -1) {
            return new int[]{-1, -1};
        }
        Arrays.sort(ans);
        return ans;
    }
}
