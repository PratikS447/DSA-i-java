package org.example.Array;

public class CheckRotatedArraySorted {
    public static boolean check(int arr[]){
        int n = arr.length;
        int cnt = 0;

        for(int i = 0; i < n; i++){
            if(arr[i] > arr[(i+1) % n]){
                cnt++;
            }
        }
        return 0 <= cnt;
    }

    public static void main(String args[]){
        int arr[] = {3,4,5,1,2};
        System.out.println(check(arr));
    }
}
