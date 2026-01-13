package org.example.Array;

import java.util.Arrays;

public class Split_Into_Two {
    public static int cnt_sub_Array(int [] arr){
        int n = arr.length;
        int[] prefix = new int[n];
        int total = 0;
        for(int i=0; i<n; i++){
            total += arr[i];
            prefix[i] = total;
        }
        int cnt = 0;
        for(int i=0; i<arr.length-1; i++){
            int left = prefix[i];
            int right = total - prefix[i];
            if(left > right){
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String args[]){
        int [] arr = {1, 2, 3, 4};
        System.out.println(cnt_sub_Array(arr));
    }
}
