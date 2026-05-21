package org.example.BinarySearch;

import java.util.Arrays;

public class Allocate_Pages {
    public static int findPages(int pages[], int student){
        if(student > pages.length) return -1;
        int l = Arrays.stream(pages).max().orElse(0), r = Arrays.stream(pages).sum();
        int ans = -1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(isValid(pages, student, mid)){
                ans = mid;
                r = mid  - 1;
            }else{
                l = mid + 1;
            }
        }
        return ans;
    }

    public static boolean isValid(int pages[], int student, int min_pages){
        int sum = 0;
        for (int page: pages){
            sum += page;
            if(sum > min_pages){
                student--;
                sum = page;
                if (student <= 0){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String args[]){
        int arr[] = {12, 34, 67, 90}, k = 2;
        System.out.println(findPages(arr, 2));
    }
}
