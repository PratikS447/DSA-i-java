package org.example.Backtracking_and_recusion.backtracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Word_Break {
    public boolean word_break(String str, String dictionary[]){
        int n = str.length();
        Set<String> set = new HashSet<>(Arrays.asList(dictionary));
        Boolean memo[] = new Boolean[n+1];
        int maxLen = 0;
        for (String word: dictionary){
            maxLen = Math.max(word.length(), maxLen);
        }

        return helper(str, set, memo, maxLen, 0);
    }

    public boolean helper(String str, Set<String> dict, Boolean memo[], int maxLen, int idx){
        if (idx == str.length()){
            return true;
        }

        if (memo[idx] != null){
            return memo[idx];
        }

        int limit = Math.min(str.length(), idx + maxLen);
        for (int j = idx+1; j <= limit; j++){
            String sub = str.substring(idx, j);
            if (dict.contains(sub) && helper(str, dict, memo, maxLen, j)){
                return memo[idx] = true;
            }
        }

        return memo[idx] = false;
    }
}
