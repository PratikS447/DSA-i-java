package org.example.HashMap;

import java.util.HashMap;
import java.util.Map;

// where elements in the array are 0, 1, 2. All must be equal.
public class Longest_sub_equal_freq {
    public static int longest_subarray(int arr[]){
        Map<String, Integer> map = new HashMap<>();
        map.put("0#0", -1);
        int c0 = 0, c1 =0, c2 =0;
        int maxLen = 0;
        for(int i = 0; i < arr.length; i++){
            if (arr[i] == 0) c0++;
            else if (arr[i] == 1) c1++;
            else if (arr[i] == 2) c2++;

            int diff1 = c0 - c1;
            int diff2 = c1 - c2;
            String str = diff1 + "#" + diff2;
            if(map.containsKey(str)){
                int prev = map.get(str);
                int curr = i - prev;
                maxLen = Math.max(maxLen, curr);
            }else {
                map.put(str, i);
            }
        }
        return maxLen;
    }

    public static void main(String args[]){
        int arr[] = {0, 1, 0, 2, 0, 1, 0};
        System.out.print(longest_subarray(arr));
    }
}
