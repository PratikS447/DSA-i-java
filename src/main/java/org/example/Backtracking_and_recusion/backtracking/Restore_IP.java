package org.example.Backtracking_and_recusion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Restore_IP {
    public static List<String> restore_Ip_Address(String s){
        List<String> ans = new ArrayList<>();
        if(s.length() < 4 || s.length() > 12) return ans;
        helper(s, new StringBuilder(), ans, 0, 0);
        return ans;
    }

    public static void helper(String s, StringBuilder partial_ans, List<String> ans, int segment, int idx){
        if(segment == 4){
            if(idx == s.length()){
                partial_ans.deleteCharAt(partial_ans.length() -1);
                ans.add(partial_ans.toString());
            }
            return;
        }

        int temp = partial_ans.length();
        if(idx+1 <= s.length()){
            String str = s.substring(idx, idx+1);
            if(isValid(str)){
                partial_ans.append(str).append('.');
                helper(s, partial_ans, ans, segment+1, idx+1);
                partial_ans.setLength(temp);
            }
        }

        if (idx+2 <= s.length()){
            String str = s.substring(idx, idx+2);
            if(isValid(str)){
                partial_ans.append(str).append('.');
                helper(s, partial_ans, ans,segment+1, idx+2);
                partial_ans.setLength(temp);
            }
        }

        if(idx+3 <= s.length()){
            String str = s.substring(idx, idx+3);
            if (isValid(str)){
                partial_ans.append(str).append('.');
                helper(s, partial_ans, ans, segment+1, idx+3);
                partial_ans.setLength(temp);
            }
        }
    }

    public static boolean isValid(String str){
        if(str.length() > 1 && str.charAt(0) == '0') return false;
        int val = Integer.parseInt(str);
        return val >= 0 && val <= 255;
    }
}
