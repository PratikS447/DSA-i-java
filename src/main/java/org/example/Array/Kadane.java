package org.example.Array;

public class Kadane {
    public static int maxSubarray(int arr[]){
        int max = 0;
        int sum = 0;

        for(int i = 0; i < arr.length; i++){
            sum = sum + arr[i];
            max = Math.max(max, sum);
            if(sum < 0){
                sum = 0;
            }
        }
        return max;
    }
    public static void main(String args[]){
        int arr[] = {2, 3, 1, -1, 0};
        System.out.print(maxSubarray(arr));
    }
}
