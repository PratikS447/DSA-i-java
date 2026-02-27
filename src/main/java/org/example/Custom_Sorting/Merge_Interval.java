package org.example.Custom_Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge_Interval {
    public static int[][] merge(int [][] intervals){
        if (intervals.length <= 1){
            return intervals;
        }
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();

        int [] currentInterval = intervals[0];
        merged.add(currentInterval);

        for (int i = 0; i < intervals.length; i++){
            int[] nextInterval = intervals[i];
            int currentEnd = currentInterval[1];
            int nextStart = nextInterval[0];
            int nextEnd = nextInterval[1];

            if (nextStart <= currentEnd){
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            }else {
                currentInterval = nextInterval;
                merged.add(currentInterval);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String args[]){
        int mat[][] = {{1,3},{2,6},{8,10},{15,18}};
        int mat1[][] = merge(mat);

        for (int i = 0; i < mat1.length; i++){
            for (int j = 0; j < mat1[0].length; j++){
                System.out.print(mat1[i][j]+" ");
            }
            System.out.println();
        }
    }
}
