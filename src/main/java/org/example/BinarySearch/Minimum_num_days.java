package org.example.BinarySearch;

import java.util.Arrays;

public class Minimum_num_days {
    public static int minDays(int[] bloomDay, int m, int k){
        if((long)m*k > bloomDay.length) return -1;
        int l = Arrays.stream(bloomDay).min().orElse(0);
        int r = Arrays.stream(bloomDay).max().orElse(0);
        int ans = -1;

        while (l <= r){
            int mid = l + (r - l) / 2;
            if(isValid(bloomDay, m, k, mid)){
                ans = mid;
                r= mid -1;
            }else{
                l = mid +1;
            }
        }
        return ans;
    }

    public static boolean isValid(int[] bloomDays, int m, int k, int req_day){
        int cnt = 0;
        int b = 0;
        for (int bloomDay: bloomDays){
            if(bloomDay <= req_day){
                cnt++;
                if(cnt == k){
                    b++;
                    cnt = 0;
                }
            }else{
                cnt = 0;
            }
        }
        return b >= m;
    }

    public static void main(String args[]){
        int arr[] = {1,10,3,10,2};
        System.out.println(minDays(arr, 2, 1));
    }
}
