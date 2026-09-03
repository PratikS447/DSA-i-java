package org.example.Backtracking_and_recusion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combination {
    public static List<List<Integer>> nCr(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(n, k, new ArrayList<>(), ans, 1);
        return ans;
    }

    public static void helper(int n, int k, List<Integer> ls, List<List<Integer>> ans, int i){
        if(ls.size() == k){
            ans.add(new ArrayList<>(ls));
            return;
        }

        for (int j = i; j <= n; j++){
            ls.add(j);
            helper(n, k, ls, ans, j+1);
            ls.remove(ls.size() -1);
        }
    }

}
