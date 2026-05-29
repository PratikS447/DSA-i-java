package org.example.HashMap;

import java.util.HashSet;
import java.util.Set;

public class Pair_Absolute_diff {
    public static int pairs_diff(int arr[], int k){
        Set<Integer> uniq_set = new HashSet<>();
        Set<Integer> dupli_set = new HashSet<>();
        int cnt = 0;

        for (int a: arr){
            if(!uniq_set.add(a)){
                dupli_set.add(a);
            }
        }

        if(k == 0){
            cnt = dupli_set.size();
        }else{
            for (int a: uniq_set){
                if (uniq_set.contains(a+k)){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String args[]){
        int arr[] = {10, 5, 10, 5, 10, 5};
        System.out.println(pairs_diff(arr, 5));
    }
}
