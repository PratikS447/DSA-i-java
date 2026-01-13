package org.example.Queue;
import java.util.LinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Task_question {
    public static List<Integer> getTaskOrder(int time[], int m){
        Queue<int[]> queue = new LinkedList<>();
        List<Integer> completed = new ArrayList<>();

        for(int i=0; i< time.length; i++){
            queue.offer(new int[]{i+1, time[i]});
        }

        while (!queue.isEmpty()){
            int [] task = queue.poll();
            int idx = task[0];
            int remaining = task[1];

            if(remaining <= m){
                completed.add(idx);
            }else {
                queue.offer(new int[]{idx, remaining-m});
            }
        }
        return completed;
    }

    public static void main(String args[]){
        int[] time = {1, 2, 3};
        int m = 1;
        System.out.print(getTaskOrder(time, m));
    }
}
