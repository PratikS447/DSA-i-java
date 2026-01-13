package org.example.Backtracking;

import java.util.HashSet;

public class PermutationString {
    public static void allPossible(String strs, String per, HashSet<String> set){
        if(strs.length() == 0){
            set.add(per);
            return;
        }

        for (int i=0; i<strs.length(); i++){
            char curr = strs.charAt(i);
            String newStr = strs.substring(0, i)+strs.substring(i+1);
            allPossible(newStr, curr+per, set);
        }

    }

    public static void main(String args[]){
        HashSet<String> ls = new HashSet<>();
        allPossible("Pratik", "", ls);
        System.out.println(ls);
    }
}
