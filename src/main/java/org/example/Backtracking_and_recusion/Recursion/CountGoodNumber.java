package org.example.Backtracking_and_recusion.Recursion;

public class CountGoodNumber {
    public static long helper(long base, long expo, long mod){
        if(expo == 0){
            return 1;
        }

        long half = helper(base, expo/2, mod);

        if(expo % 2 == 0){
            return (half*half)%mod;
        }else {
            return (base*half*half)%mod;
        }
    }

    public static int myRecursiveMethod(int n){
        if (n == 1) return 1;
        long even = (n+1)/2;
        long odd = n/2;
        long mod = 100000000 + 7;

        long result = (helper(5, even, mod) * helper(4, odd, mod)) % mod;

        return (int)result;
    }

    public static void main(String args[]){
        System.out.println(myRecursiveMethod(4));
    }
}
