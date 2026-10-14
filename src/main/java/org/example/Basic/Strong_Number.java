package org.example.Basic;

public class Strong_Number {
    public static boolean isStrong(int N){
        if (N < 1) return false;
        for (int i = 2; i <= N; i++){
            if (N%i == 0){
                if (isPrime(i)){
                    if (N%(i*i) != 0){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean isPrime(int N){
        if (N < 2) return false;
        for (int i = 2; i*i <= N; i++){
            if (N%i == 0){
                return false;
            }
        }
        return true;
    }
}
