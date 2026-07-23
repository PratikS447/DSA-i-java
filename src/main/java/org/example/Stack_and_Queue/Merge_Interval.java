package org.example.Stack_and_Queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge_Interval {
    public static int[][] merge(int arr[][], int n){
        if (arr == null || arr.length == 0){
            return new int[0][];
        }

        Arrays.sort(arr, (a,b) -> Integer.compare(a[0], b[0]));

        List<int[]> ans = new ArrayList<>();

        int curr[] = arr[0];
        ans.add(curr);

        for (int right = 1; right < arr.length; right++){
            int next[] = arr[right];
            int curr_last = curr[1];
            int next_first = next[0];
            int next_last = next[1];

            if (curr_last >= next_first){
                curr[1] = Math.max(curr[1], next_last);
            }else {
                curr = next;
                ans.add(curr);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String args[]){
        int arr[][] = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(merge(arr, 4)));
    }
}
