package org.example.Backtracking;

import java.util.HashMap;
import java.util.Map;

public class KeypadCombination {
    public static void printKPC(String ques){
        String arr[] = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
        Map<Integer, String> mp = new HashMap<>();
        for (int i = 0; i < arr.length; i++){
            mp.put(i, arr[i]);
        }
        StringBuilder ans = new StringBuilder("");
        helper(ques, ans, mp, 0);
    }
    public static void helper(String ques, StringBuilder ans, Map<Integer, String> mp, int i){
        if(ques.length() == i){
            System.out.println(ans);
            return;
        }

        int key = ques.charAt(i) - '0';
        String value = mp.get(key);

        for(int j = 0; j < value.length(); j++){
            // will choose first branch. Thus, to choose multiple branches we must use for loop.
            ans.append(value.charAt(j));
            helper(ques, ans, mp, i+1);
            ans.deleteCharAt(ans.length() -1);
        }
    }

    public static void main(String args[]){
        printKPC("781");
    }
}
