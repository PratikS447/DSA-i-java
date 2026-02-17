package org.example.Array;

import java.util.*;

public class TripletSumToK {
    public static int bruteForce(ArrayList<Integer> ls, int target){
        Set<Integer> set = new TreeSet<>(ls);
        List<Integer> uniqEle = new ArrayList<>(set);
        int cnt = 0;

        if(uniqEle.size() < 3){
            return 0;
        }

        for (int i = 0; i < uniqEle.size()-2; i++){
            for (int j = i + 1; j < uniqEle.size()-1; j++){
                for (int k = j + 1; k < uniqEle.size(); k++){
                    if(uniqEle.get(i) + uniqEle.get(j) + uniqEle.get(k) == target){
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }

    public static void main(String args[]){
        ArrayList<Integer> ls = new ArrayList<>(Arrays.asList(1,1,1,1,1,2,2,2,2));
        System.out.println(bruteForce(ls, 3));
    }
}
