package org.example.Greedy;

public class Make_Rope_Colorful {
    public int min_cost(String str, int neededTime[]){
        int min_cost = neededTime[0];
        int total = 0;
        for (int i = 1; i < str.length(); i++){
            if(str.charAt(i-1) == str.charAt(i)){
                total += Math.min(neededTime[i], min_cost);
                min_cost = Math.max(min_cost, neededTime[i]);
            }else {
                min_cost = neededTime[i];
            }
        }
        return total;
    }
}
