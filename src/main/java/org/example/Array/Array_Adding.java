package org.example.Array;

import java.util.Arrays;

public class Array_Adding {
    public static int[] arrayAdding(int arr1[], int arr2[]){
        int size = 0;
        if(arr1.length > arr2.length){
            size = arr1.length;
        }else{
            size = arr2.length;
        }
        int result[] = new int[size];
        int i = arr1.length-1;
        int j = arr2.length-1;
        int carry = 0;
        for(int k = size-1; k >= 0; k--){
            int sum = 0;
            if(i >= 0) sum += arr1[i];
            if(j >= 0) sum += arr2[j];
            sum = sum + carry;
            result[k] = sum % 10;
            carry = sum / 10;
            j--;
            i--;
        }
        if(carry > 0){
            int newRes[] = new int[size+1];
            newRes[0] = carry;
            for(int l = 0; l < result.length; l++){
                newRes[l+1] = result[l];
            }
            return newRes;
        }
        return result;
    }
    public static void main(String args[]){
        int arr1[] = {9, 9};
        int arr2[] = {1};
        System.out.println(Arrays.toString(arrayAdding(arr1, arr2)));
    }
}
