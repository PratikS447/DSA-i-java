package org.example.TwoDArray;

public class MaxColumn {
    public static void max(int arr[][]){
        for(int col = 0; col < arr.length; col++){
            int sum = 0;
            for (int row = 0; row < arr[0].length; row++){
                sum = sum + arr[col][row];

            }
        }
    }
}
