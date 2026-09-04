package org.example.TwoPointer_SlidingWindow;

import java.util.Arrays;

public class Number_Of_Valid_Triangle {
    public static int triangle(int arr[]){
        Arrays.sort(arr);
        int cnt = 0;
        int n = arr.length;
        for(int k = n -1; k >= 2; k--){
            int i = 0;
            int j = k -1;
            while (i < j){
                if(arr[i] + arr[j] > arr[k]){
                    cnt += j -i;
                    j--;
                }else{
                    i++;
                }
            }
        }
        return cnt;
    }
}
