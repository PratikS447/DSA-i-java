package org.example.BinarySearch;

import java.util.Arrays;

public class Aggressive_cows {
    public static int aggressive_cow(int stalls[], int cows){
        Arrays.sort(stalls);
        int l = 1, r = stalls[stalls.length -1];
        int ans = 0;
        while (l <= r){
            int mid = l + (r - l)/2;
            if(isValid(stalls, cows, mid)){
                ans = mid;
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static boolean isValid(int stalls[], int cows, int max_dist){
        int last = stalls[0];
        cows--;
        for (int i = 1; i < stalls.length; i++){
            if(stalls[i] - last >= max_dist){
                cows--;
                last = stalls[i];
                if(cows == 0){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String args[]){
        int arr[] = {1, 2, 4, 8, 9};
        int k = 3;
        System.out.println(aggressive_cow(arr, k));
    }
}
