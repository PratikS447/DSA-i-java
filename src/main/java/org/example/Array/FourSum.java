package org.example.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static List<List<Integer>> four_Sum(int arr[], int target){
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        int n = arr.length -1;
        for (int i = 0; i < arr.length-3; i++){
            if(i > 0 && arr[i-1] == arr[i]){
                continue;
            }
            for (int j = i+1; j < arr.length-2; j++){
                if (j > i+1 && arr[j-1] == arr[j]){
                    continue;
                }
                int k = j + 1;
                int l = n;
                while (k < l){
                    long sum = (long) arr[i] + arr[j] + arr[k] + arr[l];
                    if(sum < target){
                        k++;
                    } else if (sum > target) {
                        l--;
                    }else{
                        ans.add(Arrays.asList(arr[i], arr[j], arr[k], arr[l]));
                        k++;
                        l--;
                        while (k < l && arr[k-1] == arr[k]) k++;
                        while (k < l && arr[l+1] == arr[l]) l--;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String args[]){
        int arr[] = {2,2,2,2,2};
        System.out.println(four_Sum(arr, 8));
    }
}
