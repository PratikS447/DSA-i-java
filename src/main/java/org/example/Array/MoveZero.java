package org.example.Array;

import java.util.Arrays;

public class MoveZero {
    public static void method(int arr[]){
        int cnt = 0;
        for (int i = 0; i < arr.length; i++){
            if(arr[i] != 0){
                arr[cnt] = arr[i];
                cnt++;
            }
        }
        for (int i = cnt; i < arr.length; i++){
            arr[i] = 0;
        }
    }

    public static void main(String args[]){
        int arr[] = {0,1,0,3,12};
        method(arr);
        System.out.print(Arrays.toString(arr));
    }
}
