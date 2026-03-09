package org.example.Backtracking;

public class PrintAllSubsequence {
    public static void subSequence(String str){
        StringBuilder sb = new StringBuilder("");
        helper(str, sb, 0);
    }

    public static void helper(String str, StringBuilder sb, int i){
        if(i == str.length()){
            System.out.print(sb.toString()+" ");
            return;
        }

        // will take
        sb.append(str.charAt(i));
        helper(str, sb, i+1);

        // Cleaning step / backtrack
        sb.deleteCharAt(sb.length() -1);

        // will not take
        helper(str, sb, i+1);
    }

    public static void main(String args[]){
        subSequence("abcd");
    }
}
