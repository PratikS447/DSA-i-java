package org.example.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MajorityElement {
    public static int mores_Algo(int arr[]){
        int candidate = 0;
        int cnt = 0;
        for (int i : arr){
            if(cnt == 0){
                candidate = i;
            }
            if (cnt == candidate) {
                cnt++;
            }else{
                cnt--;
            }
            if(cnt >= arr.length/2){
                return candidate;
            }
        }
        return candidate;
    }

    public static List<Integer> majorityElement2(int nums[]){
        int cnt1 = 0, cnt2 = 0;
        int ele1 = 0, ele2 = 0;

        for (int i = 0; i < nums.length; i++){
            if(cnt1 > 0 && nums[i] == ele1){
                cnt1++;
            }else if(cnt2 > 0 && nums[i] == ele2){
                cnt2++;
            } else if (cnt1 == 0) {
                ele1 = nums[i];
                cnt1 = 1;
            } else if (cnt2 == 0) {
                ele2 = nums[i];
                cnt2 = 1;
            }else{
                cnt1--;
                cnt2--;
            }
        }

        int check1 = 0, check2 = 0;
        List<Integer> ls = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            if(nums[i] == ele1){
                check1++;
            } else if (nums[i] == ele2) {
                check2++;
            }
        }

        if(check1 > nums.length/3){
            ls.add(ele1);
        }
        if (check2 > nums.length/3) {
            ls.add(ele2);
        }
        Collections.sort(ls);
        return ls;
    }

    public static void main(String args[]){
        int arr[] = {1,2};
        System.out.print(majorityElement2(arr));
    }
}
