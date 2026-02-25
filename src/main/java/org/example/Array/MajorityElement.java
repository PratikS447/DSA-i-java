package org.example.Array;

public class MajorityElement {
    public static int mores_Algo(int arr[]){
        int candidate = 0;
        int cnt = 0;
        for (int i : arr){
            if(cnt == 0){
                candidate = i;
            }
            if (cnt == candidate) {
                cnt++;
            }else{
                cnt--;
            }
            if(cnt >= arr.length/2){
                return candidate;
            }
        }
        return candidate;
    }

    public static void main(String args[]){
        int arr[] = {2,2,1,1,1,2,2};
        System.out.print(mores_Algo(arr));
    }
}
