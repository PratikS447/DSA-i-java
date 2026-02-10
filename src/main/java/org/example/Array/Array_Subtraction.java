package org.example.Array;

import java.util.Arrays;

public class Array_Subtraction {
    public static int[] arrSubtract(int arr1[], int arr2[]){
        int size = arr1.length > arr2.length ? arr1.length : arr2.length;
        int diff[] = new int[size];

        int i = arr1.length -1; int j = arr2.length -1;
        int k = size-1;
        int borrow = 0;

        while (k >= 0){
            int digitValue = arr1[i] - borrow;

            if(j >= 0){
                digitValue = digitValue - arr2[j];
            }

            if(digitValue < 0){
                digitValue += 10;
                borrow = 1;
            }else {
                borrow = 0;
            }

            diff[k] = digitValue;

            i--; j--; k--;
        }
        return diff;
    }

    public static void main(String args[]){
        int arr1[] = {3, 2, 1};
        int arr2[] = {1, 2, 3};
        System.out.println(Arrays.toString(arrSubtract(arr1, arr2)));
    }
}
