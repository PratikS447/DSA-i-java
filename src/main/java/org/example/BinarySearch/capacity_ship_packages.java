package org.example.BinarySearch;

import java.util.Arrays;

public class capacity_ship_packages {
    public static int shipment_within_days(int weights[], int days){
        int l = Arrays.stream(weights).max().getAsInt();
        int r = Arrays.stream(weights).sum();
        int ans = 0;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(isValid(weights, days, mid)){
                ans = mid;
                r = mid -1;
            }else{
                l = mid +1;
            }
        }
        return ans;
    }

    public static boolean isValid(int weights[], int days, int min_cap){
        int cap = 0;
        for(int weight: weights){
            cap += weight;
            if(cap > min_cap){
                days--;
                cap = weight;
                if(days <= 0){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String args[]){
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(shipment_within_days(arr, 5));
    }
}
