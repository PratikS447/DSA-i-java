package org.example.BinarySearch;

import java.util.Arrays;

public class Koko_Eating_Bananas {
    public static int eating_bananas(int arr[], int hrs){
        int left = 1, right = Arrays.stream(arr).max().getAsInt();
        int ans = arr.length;
        while (left <= right){
            int mid = left+(right -left)/2;
            if(isValid(arr, hrs, mid)){
                ans = mid;
                right = mid -1;
            }else {
                left = mid +1;
            }
        }
        return ans;
    }

    public static boolean isValid(int arr[], int hrs, int ate){
        int sum = 0;
        for (int a: arr){
            sum += (int)Math.ceil((double) a/ate);
            if(sum > hrs){
                return false;
            }
        }
        return true;
    }
}
