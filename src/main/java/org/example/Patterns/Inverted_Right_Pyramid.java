package org.example.Patterns;

public class Inverted_Right_Pyramid {
    //            * * * * * *
    //            * * * * *
    //            * * * *
    //            * * *
    //            * *
    //            *
    public static void Inverted_Right_star(int n){
        for (int i=1; i<n; i++){
            for (int j=i; j<n; j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

//            1 2 3 4 5
//            2 3 4 5
//            3 4 5
//            4 5
//            5
    public static void Inverted_Right_number(int n){
        for (int i=1; i<n; i++){
            for (int j=i; j<n; j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    //            1 2 3 4 5
    //            1 2 3 4
    //            1 2 3
    //            1 2
    //            1

    public static void Inverted_Right_number_2(int n){
        for (int i=1; i<n; i++){
            int cnt = 1;
            for (int j=i; j<n; j++){
                System.out.print(cnt+" ");
                cnt++;
            }
            System.out.println();
        }
    }

//            1 2 3 4 5
//            1 2 3 4
//            1 2 3
//            1 2
//            1

    public static void Inverted_right_star(int n){
        for (int i=1; i<=n; i++){
            for (int j=1; j<=n-i; j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]){
        Inverted_right_star(6);
    }
}
