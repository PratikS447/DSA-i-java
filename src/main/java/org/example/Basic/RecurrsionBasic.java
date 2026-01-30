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

    public static int sum1(int currSum, int n){
        if (n == 0){
            return currSum;
        }

        return sum1(currSum+n, n-1);
    }

//    factorial of n numbers
    public static int fact(int n){
        if (n < 1){
            return 1;
        }
        return n * fact(n-1);
    }

//    REVERSE AN ARRAY
    public static void reveArray(int [] arr, int idx){
        if (idx == arr.length){
            return;
        }
        System.out.print(arr[arr.length -1 - idx]+" ");
        reveArray(arr, idx+1);
    }

//    CHECK IF STRING IS PALIDROM OR NOT
    public static boolean isPalidrom(String str, int start, int end){
        if (start >= end){
            return true;
        }
        if (str.charAt(start) != str.charAt(end)){
            return false;
        }

        return isPalidrom(str, start+1, end-1);
    }

//    Print Fibonacci Series up to Nth term
    public static int fibSeries(int n){
        if (n <= 1){
            return n;
        }

        return fibSeries(n-1) + fibSeries(n-2);
    }

    public static void main(String args[]){
//        printnNumber(5, 1);
//        reverseNumber(5);
//        System.out.print(sum(5));
//        System.out.print(fact(5));
//        System.out.print(sum1(0, 5));
//        int arr[] = {1,2,3,4,5};
//        reveArray(arr, 0);
//        String str = "madam";
//        System.out.print(isPalidrom(str, 0, str.length()-1));
        for (int i = 0; i < 5; i++){
            System.out.print(fibSeries(i));
        }
    }
}
