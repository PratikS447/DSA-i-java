package org.example.Backtracking.Recursion;

public class Power {
    public static int myPow(double x, int n){
        if(n == 0){
            return 1;
        }
        if(x == 0){
            return 0;
        }
        if(n % 2 == 0){
            return myPow(x, n/2)*myPow(x, n/2);
        }else{
            return (int)x * myPow(x, n/2)*myPow(x, n/2);
        }
    }
    public static void main(String args[]){

    }
}
