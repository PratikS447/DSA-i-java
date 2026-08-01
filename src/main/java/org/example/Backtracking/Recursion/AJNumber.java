package org.example.Backtracking.Recursion;

public class AJNumber {
    public static void solve(StringBuilder str, int n){
        System.out.println(helper(str, 0));
    }

    public static int helper(StringBuilder str, int idx){
        int global_ans = 0;
        for (int i = idx; i < str.length(); i++){
            int local_ans = 0;
            for (int j = i; j < str.length(); j++){
                String subString = str.substring(i, j+1);
                if(isPrime(subString)){
                    local_ans = 1 + helper(str, j+1);
                    break;
                }

            }
            if(global_ans < local_ans){
                global_ans = local_ans;
            }
        }
        return global_ans;
    }

    public static boolean isPrime(String subString){
        long num = Long.parseLong(subString);
        int arr[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        if(num == 0 || num == 1) return false;
        for (int i = 0; i < arr.length; i++){
            if(num == arr[i]) return true;
            if(num % arr[i] == 0) return false;
        }

        return true;
    }
    public static void main(String args[]){
        StringBuilder str = new StringBuilder("81615");
        solve(str, 5);
    }
}
