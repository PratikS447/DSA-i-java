package org.example.Basic;

public class RecurrsionBasic {
    public static void printnNumber(int n, int i){
        if (n < i){
            return;
        }
        System.out.print(i+" ");
        printnNumber(n, i+1);
    }

    public static void reverseNumber(int n){
        if (n == 0){
            return;
        }
        System.out.print(n+" ");
        reverseNumber(n-1);
    }

    public static void main(String args[]){
//        printnNumber(5, 1);
        reverseNumber(5);
    }
}
