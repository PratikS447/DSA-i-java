package org.example.Basic;

import java.util.ArrayList;
import java.util.List;

public class Math_Basic {
//    COUNT DIGIT IN A NUMBER.
    public static int countDigit(int n){
        int cnt = 0;
        while(0 < n){
            int ans = n % 10;
            n = n / 10;
            cnt++;
        }
        return cnt;
    }

    // REVERSE A DIGIT.
    public static int reverseDigit(int n){
        int rev = 0;
        while(n != 0){
            rev = (rev*10) + n % 10;
            n = n/ 10;
        }
        return rev;
    }

    // IS PALIDROM
    public static boolean isPalidrom(int n){
        if(n == reverseDigit(n)){
            return true;
        }else {
            return false;
        }
    }

    // GCD
    public static int gcd(int first, int second) {
        int gcd = 1;
        // The fix: Use <= so the loop actually checks the smaller number
        for (int i = 1; i <= first && i <= second; i++) {
            if (first % i == 0 && second % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    // ARMSTRONG
    public static boolean isArmstrong(int n){
        int size = 0;
        while (n != 0){
            size++;
            n = n / 10;
        }

        double ans = 0;
        while (n != 0){
            ans += Math.pow(n, size);
            n = n / 10;
        }

        if (ans == n){
            return true;
        }

        return false;
    }

    // DIVISOR
    // BRUTE FORCE : O(N)
    public static List<Integer> divisor(int n){
        List<Integer> ls = new ArrayList<>();
        for (int i = 1; i <= n; i++){
            if(n % i == 0){
                ls.add(i);
            }
        }
        return ls;
    }

//    OPTIMIZE
    public static List<Integer> divisor1(int n){
        List<Integer> ls = new ArrayList<>();
        for (int i = 1; i*i <= n; i++){
            if (n % i == 0){
                ls.add(i);
                if(i != (n/i)){
                    ls.add(n/i);
                }
            }
        }
        return ls;
    }

//    PRIME NUMBER
    public static boolean isPrime(int n){
        for (int i = 2; i < n; i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }

    public static boolean isPrime1(int n){
        if (n < 2){
            return false;
        }
        for (int i = 2; i*i < n; i++){
            if (n % i == 0){
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]){
//        System.out.print(countDigit(12345));
//        System.out.print(reverseDigit(12345));
//        int ans = gcd(153, 9);
//        System.out.println(ans);
//        System.out.print(isArmstrong(153));
//        System.out.print(divisor(36));
//        System.out.print(divisor1(36));
        System.out.print(isPrime1(19));
    }
}
