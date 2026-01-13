package org.example.Patterns;

public class Star_Pyramid {
//                      *
//                    * * *
//                  * * * * *
//                 * * * * * * *
    public static void star_pyramid(int n){
        for (int i=0; i < n; i++){
            // Print spaces
            for (int j = 0; j <= n; j++){
                System.out.print("  ");
            }

            for (int j = 0; j < 2*i +1; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

//          * * * * * * * * *
//            * * * * * * *
//              * * * * *
//                * * *
//                  *
    public static void Inverted_Star_Pyramid(int n){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < i; j++){
                System.out.print("  ");
            }

            for (int j = 0; j < 2*(n - i) - 1; j++){
                System.out.print("* ");
            }

            System.out.println();
        }

    }

    //                      *
    //                    * * *
    //                  * * * * *
    //                * * * * * * *
    //              * * * * * * * * *
    //              * * * * * * * * *
    //                * * * * * * *
    //                  * * * * *
    //                    * * *
    //                      *

    public static void Diamond_Star_Pattern(int n){
        for (int i=0; i < n; i++){
            for (int j = 0; j < n - i -1; j++){
                System.out.print("  ");
            }

            for (int j = 0; j < 2*i + 1; j++){
                System.out.print("* ");
            }

            System.out.println();
        }
        for (int i= 0; i < n; i++){
            for (int j = 0; j < i; j++){
                System.out.print("  ");
            }
            for (int j = 0; j < 2*(n - i) - 1; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

//            *
//            * *
//            * * *
//            * * * *
//            * * * * *
//            * * * *
//            * * *
//            * *
//            *

    public static void Half_Diamond(int n){
        for (int i = 0; i < n; i++){
            for (int j = 0; j <= i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = 0; i < n -1; i++){
            for (int j = 0; j < n - i - 1; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        Half_Diamond(6);
    }
}
