package org.example.BinarySearch;

public class Book_Allocation {

    public static int book(int pages[], int student){
        int l = 0;
        for(int page: pages){
            l = Math.max(page, l);
        }
        int r = 0;
        for(int page: pages){
            r += page;
        }
        int ans = -1;
        while(l <= r){
            int mid = l + (r - l)/2;
            if(isValid(pages, student, mid)){
                ans = mid;
                r = mid -1;
            }else{
                l = mid +1;
            }
        }
        return ans;
    }
    public static boolean isValid(int pages[], int req_student, int min_pages){
        int allocated = 0;
        for (int page: pages){
            allocated += page;
            if(allocated > min_pages){
                req_student--;
                if(req_student == 0){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String args[]){
        int arr[] = {12, 34, 67, 90};
        System.out.println(book(arr, 2));
    }
}
