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
//            A
//          A B A
//        A B C B A
//      A B C D C B A
//    A B C D E D C B A
    public static void Alpha_Hill(int n){

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n - i -1; j++){
                System.out.print("  ");
            }
            char ch = 'A';
            int breaks = (2*i + 1) / 2;
            for (int k = 0; k < 2*i+1; k++){
                System.out.print(ch+" ");
                if( k < breaks) ch++;
                else ch--;
            }
            System.out.println();
        }
    }

//    F
//    E F
//    D E F
//    C D E F
//    B C D E F

    public static void Alpha_Triangle(int n){
        for (int i = 0; i < n; i++){
            char ch = (char) ('A' + n - i);
            for (int j = 0; j < i + 1; j ++){
                System.out.print(ch+" ");
                ch++;
            }

            System.out.println();
        }
    }

//            * * * * * * * * * *
//            * * * *     * * * *
//            * * *         * * *
//            * *             * *
//            *                 *
//            *                 *
//            * *             * *
//            * * *         * * *
//            * * * *     * * * *
//            * * * * * * * * * *

    public static void Symm_void_patt(int n){
        for (int i = 0; i < n; i ++){
            for (int j = 0; j < n - i; j++){
                System.out.print("* ");
            }
            for (int k = 0; k < i; k ++){
                System.out.print("  ");
            }
            for (int l = 0; l < i; l++){
                System.out.print("  ");
            }
            for (int m = 0; m < n - i ; m++){
                System.out.print("* ");
            }
            System.out.println();
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j <= i; j++){
                System.out.print("* ");
            }

            for (int k = 0; k < n - i -1; k ++){
                System.out.print("  ");
            }

            for (int l = 0; l < n - i -1; l++){
                System.out.print("  ");
            }

            for (int m = 0; m < i+1; m++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

//            *                   *
//            * *               * *
//            * * *           * * *
//            * * * *       * * * *
//            * * * * *   * * * * *
//            * * * *       * * * *
//            * * *           * * *
//            * *               * *
//            *                   *


    public static void SymmButterfly(int n){
        for (int i = 0; i < n; i++){
            for (int j = 0; j <= i; j++){
                System.out.print("* ");
            }
            for (int k = 0; k < n - i; k++){
                System.out.print("  ");
            }
            for (int l = 0; l < n- i -1; l++){
                System.out.print("  ");
            }
            for (int m = 0; m <= i; m++){
                System.out.print("* ");
            }
            System.out.println();
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n -i -1; j++){
                System.out.print("* ");
            }

            for (int k = 0; k <= i+1; k++){
                System.out.print("  ");
            }

            for (int l = 0; l <= i ; l++){
                System.out.print("  ");
            }

            for (int m = 0; m < n-i -1; m++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

//            * * * *
//            *     *
//            *     *
//            * * * *

    public static void hollow_rectangle(int n){
        for (int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if (i == 0 || i == n-1 || j == 0 || j == n-1){
                    System.out.print("* ");
                }else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

//            5 5 5 5 5 5 5 5 5
//            5 4 4 4 4 4 4 4 5
//            5 4 3 3 3 3 3 4 5
//            5 4 3 2 2 2 3 4 5
//            5 4 3 2 1 2 3 4 5
//            5 4 3 2 2 2 3 4 5
//            5 4 3 3 3 3 3 4 5
//            5 4 4 4 4 4 4 4 5
//            5 5 5 5 5 5 5 5 5

    public static void num_pattern(int n){
        int size = 2 * n -1;
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                int top = i;
                int left = j;
                int bottom = (size-1) - i;
                int right = (size -1) - j;

                int value = n - Math.min(Math.min(top, bottom), Math.min(left, right));
                System.out.print(value+" ");
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
//        Alpha_Hill(5);
//        Alpha_Triangle(5);
//        Symm_void_patt(5);
//        SymmButterfly(5);
//        hollow_rectangle(4);
//        num_pattern(5);
    }
}
