package org.example.Patterns;

public class SpecialPatterns {
//           ****
//             *
//            *
//           ****

    public static void printZ(int n){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if(i == 0 || n - i == j || i == n-1){
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    // 	   1
    //    212
    //   32123
    //  4321234
    // 543212345
    //  4321234
    //   32123
    //    212
    //     1
    public static void rombus(int n){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n - i; j++){
                System.out.print(" ");
            }
            int ele = i;
            for (int k = 1; k <= 2*i-1; k++){
                System.out.print(ele);
                if(k < i){
                    ele--;
                }else{
                    ele++;
                }
            }
            System.out.println();
        }

        for(int i = 1; i <= n-1; i++){
            for (int j = 1; j <= i; j++){
                System.out.print(" ");
            }
            int ele = n -i;
            for (int k = 1; k <= 2*(n - i) -1; k ++){
                System.out.print(ele);
                if (k <  n - i){
                    ele--;
                }else {
                    ele++;
                }
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
//        printZ(4);
        rombus(5);
    }
}
