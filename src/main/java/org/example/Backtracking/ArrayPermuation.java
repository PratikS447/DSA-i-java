package org.example.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class ArrayPermuation {
    public static void print(List<Integer> curr, List<List<Integer>> ans, int [] arr){
        if(arr.length == curr.size()){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i=0; i<arr.length; i++) {
            if (!curr.contains(arr[i])) {
                curr.add(arr[i]);
                print(curr, ans, arr);
                curr.remove(curr.size() -1);
            }
        }
    }

    public static void main(String args[]){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        int [] arr = {1,2,3};
        print(ls, ans, arr);
        System.out.print(ans);
    }
}
