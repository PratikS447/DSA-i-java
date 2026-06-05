package org.example.BinarySearch;

public class Minimum_ball_In_Bag {
    public static int min_ball(int arr[], int max_op){
        int left = 1, right = 0;
        for(int a: arr){
            right = Math.max(right, a);
        }
        int ans = right;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(isValid(arr, max_op, mid)){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return ans;
    }

    public static boolean isValid(int arr[], int max_op, int penalty){
        int op = 0;
        for(int a: arr){
            op += (a-1) / penalty;
            if(op > max_op){
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]){
        int arr[] = {2 ,4 ,8 ,2};
        System.out.println(min_ball(arr, 4));
    }
}
