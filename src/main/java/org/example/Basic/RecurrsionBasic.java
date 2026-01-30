package org.example.Basic;

public class RecurrsionBasic {

//    Print 1 to N using Recursion
    public static void printnNumber(int n, int i){
        if (n < i){
            return;
        }
        System.out.print(i+" ");
        printnNumber(n, i+1);
    }

//    Print N to 1 using Recursion
    public static void reverseNumber(int n){
        if (n == 0){
            return;
        }
        System.out.print(n+" ");
        reverseNumber(n-1);
    }

//    Sum of first n numbers
    public static int sum(int n){
        if (n == 0){
            return 0;
        }

        return n + sum(n-1);
    }

    public static void main(String args[]){
//        printnNumber(5, 1);
//        reverseNumber(5);
        System.out.print(sum(5));
    }
}
