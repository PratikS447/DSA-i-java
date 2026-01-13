package org.example.Patterns;

public class Right_Angled_Triangle {
//            *
//            * *
//            * * *
//            * * * *
//            * * * * *
//            * * * * * *
    public static void star(int n){
        for (int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
//            1
//            1 2
//            1 2 3
//            1 2 3 4
//            1 2 3 4 5
//            1 2 3 4 5 6
    public static void number_pyramid(int n){
        for (int i=1; i<=n; i++){
            for (int j=1; j<=i; j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    //            1
    //            2 2
    //            3 3 3
    //            4 4 4 4
    //            5 5 5 5 5
    //            6 6 6 6 6 6
    public static void Number_Pyramid_2(int n){
        for (int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public static void Binary_Number_Triangle(int n){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){

            }
        }
    }

//        0
//        1 0
//        0 1 0
//        1 0 1 0
//        0 1 0 1 0
    public static void Binary_right_tri(int n){
        for (int i = 1; i <= n; i++){
            int x = (i % 2 == 1) ? 0 : 1;
            for (int j = 1; j <= i; j++){
                System.out.print(x+" ");
                x = 1 - x;
            }
            System.out.println();
        }
    }
//            1             1
//            1 2         2 1
//            1 2 3     3 2 1
//            1 2 3 4 4 3 2 1
    public static void Crown_Pattern(int n){
        for (int i=1; i <= n; i++){
            for (int j = 1; j < i; j++){
                System.out.print(j+" ");
            }
            for (int j = 1; j <= 2*(n - i) ; j++){
                System.out.print("  ");
            }
            for (int k = 1; k <= i -1; k++){
                System.out.print(i- k + " ");
            }

            System.out.println();
        }
    }

//            1
//            2 3
//            4 5 6
//            7 8 9 10
//            11 12 13 14 15


    public static void Increasing_Number(int n){
        int cnt = 1;
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= i; j++){
                System.out.print(cnt + " ");
                cnt++;
            }
            System.out.println();
        }
    }

//    A
//    A B
//    A B C
//    A B C D
//    A B C D E
    public static void Letter_Triangle(int n){
        for (int i = 1; i <= n; i++){
            int cnt = 0;
            for (int j = 1; j <= i; j++){
                char m = (char)('A' + cnt);
                System.out.print(m + " ");
                cnt++;
            }
            System.out.println();
        }
    }

//    A B C D E
//    A B C D
//    A B C
//    A B
//    A
    public static void Reverse_Letter_Triangle(int n){

        for (int i = 1; i <= n; i++){
            int cnt = 0;
            for (int j = 1; j <= n - i+1; j++){
                char m = (char)('A'+cnt);
                System.out.print(m+" ");
                cnt++;
            }
            System.out.println();
        }
    }
//    A
//    B B
//    C C C
//    D D D D
//    E E E E E

    public static void Alpa_Ramp(int n){
        int cnt = 0;
        for (int i = 0; i < n; i++){
            char c = (char)('A'+cnt);
            for (int j = 0; j <= i; j++){
                System.out.print(c+" ");
            }
            cnt++;
            System.out.println();
        }
    }

    public static void Alpha_Hill(int n){
        for (int i = 0; i < n; i++){

            for (int j = 0; j < n - i; j++){
                System.out.print("  ");
            }
            int cnt = 0;
            for (int k = 0; k <= 2*i ; k++){
                char c = (char) ('A' + cnt);
                System.out.print(c+" ");
                cnt++;
            }

            System.out.println();
        }
    }

    public static void main(String args[]){
//        star(6);
//        number_pyramid(6);
//        Number_Pyramid_2(6);
//        Binary_right_tri(5);
//        Crown_Pattern(5);
//        Letter_Triangle(5);
//        Alpa_Ramp(5);
        Alpha_Hill(5);
    }
}
