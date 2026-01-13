package org.example.Array;

public class Second_smallest {
    public static int method_1(int arr[]){
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for(int i=0; i< arr.length; i++){
            if(arr[i] < first){
                second = first;
                first = arr[i];
            } else if (arr[i] < second && arr[i] > first) {
                second = first;
            }
        }
        if(second == Integer.MAX_VALUE){
            return -1;
        }
        return second;
    }

    public static void main(String args[]){

    }
}
