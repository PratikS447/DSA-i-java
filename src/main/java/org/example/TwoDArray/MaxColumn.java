package org.example.TwoDArray;

public class MaxColumn {
    public static int max(int arr[][]){
        int max = 0;
        for(int col = 0; col < arr.length; col++){
            int sum = 0;
            for (int row = 0; row < arr[0].length; row++){
                sum = sum + arr[row][col];
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String args[]){
        int arr[][] = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("Maximum column in an array : "+ max(arr));
    }
}
