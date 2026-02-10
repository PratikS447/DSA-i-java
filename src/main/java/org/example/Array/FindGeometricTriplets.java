package org.example.Array;

public class FindGeometricTriplets {
    public static void geometricTriplet(int arr[]){
        for (int i = 0; i < arr.length-2; i++){
            for (int j = i+1; j < arr.length-1; j++){
                for (int k = j+1; k < arr.length; k++){
                    int a = arr[i];
                    int b = arr[j];
                    int c = arr[k];

                    if(b*b == a*c){
                        System.out.println(a+" "+b+" ");
                    }
                }
            }
        }
    }

    public static void main(String args[]){
        int arr[] = {1, 2, 6, 10, 18, 54};
        geometricTriplet(arr);
    }
}
