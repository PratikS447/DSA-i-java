package org.example.TwoDArray;

import java.util.ArrayList;
import java.util.List;

public class Pascal_Traingle {
    public static List<List<Integer>> pascal(int num){
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < num; i++){
            List<Integer> ls = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                ls.add(1);
            }
            ans.add(ls);
        }


        for (int i = 1; i < num; i++){
            int size = ans.get(i).size();
            for (int j = 1; j < size-1; j++){
                int first = ans.get(i-1).get(j-1);
                int second = ans.get(i-1).get(j);
                ans.get(i).set(j, first+second);
            }
        }
        return ans;
    }

    public static void main(String args[]){
        System.out.println(pascal(5));
    }
}
