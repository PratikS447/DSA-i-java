package CodeForce;

import java.util.Arrays;

public class BMaximum {
    public static int n;
    public static long BMaximum(long arr[], int k){
        n = arr.length;
        Arrays.sort(arr);
        long prefix[] = build_prefix(arr);
        return helper(prefix, k);
    }

    public static long[] build_prefix(long arr[]){
        long prefix[] = new long[n+1];
        for (int i = 0; i < n; i++){
            prefix[i+1] = prefix[i] + arr[i];
        }
        return prefix;
    }

    public static long helper(long prefix[], int k){
        long max = 0;
        for (int i = 0; i <= k; i++){
            int small_num = 2*i;
            int larg_num = k -i;

            if (small_num > n) break;
            if (small_num + larg_num > n) continue;

            long small_sum = prefix[small_num];
            long large_sum = prefix[n] -prefix[n- larg_num];
            long rem = prefix[n] -large_sum -small_sum;

            max = Math.max(max, rem);
        }
        return max;
    }
}
