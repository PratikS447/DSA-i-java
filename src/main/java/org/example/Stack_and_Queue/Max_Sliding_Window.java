package org.example.Stack_and_Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Max_Sliding_Window {
    public static int[] max_slide(int nums[], int k){
        int n = nums.length;
        int ans[] = new int[n -k +1]; int idx = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++){
            if(!dq.isEmpty() && i - dq.peekFirst() >= k){
                dq.pollFirst();
            }

            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
                dq.pollLast();
            }

            dq.offer(i);

            if (i >= k-1){
                ans[idx++] = nums[dq.peekFirst()];
            }
        }
        return ans;
    }
}
