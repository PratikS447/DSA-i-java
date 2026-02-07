package org.example.Array;

public class Building {
    public static void build(int arr[]){
        int max = arr[0];
        for(int i = 1; i < arr.length; i++){
            max = Math.max(max, arr[i]);
        }
        for (int i = max; i >= 0; i--){
            for (int j = 0; j < arr.length; j++){
                if(arr[j] >= i){
                    System.out.print("*\t");
                }else{
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }

    public static void main(String args[]){
        int arr[] = {9, 3, 7, 6, 2, 0, 4};
        build(arr);
    }
}
