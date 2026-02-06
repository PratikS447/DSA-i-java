package org.example.Array;

public class Leap_Year {
    public static int leapYear(int n){
        if(n % 400 == 0){
            return 1;
        }else if (n % 100 == 0){
            return 0;
        } else if (n % 4 == 0) {
            return 1;
        }else {
            return 0;
        }
    }
    public static void main(String args[]){
        System.out.print(leapYear(2000));
    }
}
