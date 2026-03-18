package org.example.Recursion;

import java.util.Scanner;

public class WaysTFormNaturalNumber {
    public static int ways(int n, int i){
        int count = 1;
        for(int j = i; 2*j <= n-1; j++){
            count += ways(n - j, j+1);
        }
        return count;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        System.out.println(ways(number, 1));
    }
}
