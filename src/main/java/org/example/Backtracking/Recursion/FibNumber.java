package org.example.Backtracking.Recursion;

public class FibNumber {
    public static int fibnocii(int n){
        if(n == 0) return 0;
        if (n == 1) return 1;

        return fibnocii(n -1) + fibnocii(n -2);
    }

    public static void main(String args[]){
        int n = 5;
        for (int i = 0; i < n; i++) {
            System.out.println(fibnocii(i));
        }
    }
}
