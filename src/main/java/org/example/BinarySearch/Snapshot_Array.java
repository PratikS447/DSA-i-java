package org.example.BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class Snapshot_Array {
    List<int[]>[] arr;
    int snap_id;
    Snapshot_Array(int length){
        arr = new ArrayList[length];
        for (int i = 0; i < arr.length; i++){
            arr[i] = new ArrayList<>();
            arr[i].add(new int[]{0, 0});
        }
    }

    public int snap(){
        return snap_id++;
    }

    public void set(int idx, int val){
        arr[idx].add(new int[]{snap_id, val});
    }

    public int get_snap_id(int idx, int snap_id){
        int left = 0, right = arr[idx].size() -1;
        int ans = 0;
        while(left <= right){
            int mid = left +(right -left)/2;
            int temp[] = arr[idx].get(mid);
            if(temp[0] <= snap_id){
                ans = temp[1];
                left = mid +1;
            }else {
                right = mid -1;
            }
        }
        return ans;
    }
}
