package org.example.String;

public class Ptice {
    public static void ptice_Solution(String key, int n){
        String Adrian = "ABC";
        String Bruno = "BABC";
        String Goran = "CCAABBCC";

        int cntA = 0;
        int cntB = 0;
        int cntC = 0;

        for (int i = 0; i < key.length(); i++){
            if(key.charAt(i) == Adrian.charAt(i % Adrian.length())){
                cntA++;
            }
            if(key.charAt(i) == Bruno.charAt(i % Bruno.length())){
                cntB++;
            }
            if(key.charAt(i) == Goran.charAt(i % Goran.length())){
                cntC++;
            }
        }

        int max = Math.max(cntA, Math.max(cntB, cntC));

        if(max == cntA){
            System.out.println("Adrian");
        }
        if(max == cntB){
            System.out.println("Bruno");
        }
        if(max == cntC){
            System.out.println("Goran");
        }
    }
    public static void main(String args[]){
        ptice_Solution("AAAABBBBB", 9);
    }
}
