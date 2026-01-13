package org.example.Patterns;

public class Rectangular_star_pattern {
//            * * * * *
//            * * * * *
//            * * * * *
//            * * * * *
//            * * * * *
    public static void main(String args[]){
        int n = 6;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
