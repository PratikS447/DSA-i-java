package org.example.BinarySearch;

public class Cake_to_Bake {

    public static int bake_cake(int flavour_day[], int k, int m){
        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
        for(int flav: flavour_day){
            left = Math.min(left, flav);
            right = Math.max(flav, right);
        }
        int ans = -1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if(isValid(flavour_day, k, m, mid)){
                ans = mid;
                right = mid -1;
            }else{
                left = mid +1;
            }
        }
        return ans;
    }

    public static boolean isValid(int flav_day[], int k, int m, int min_day){
        int adj_flav = 0;
        int cake = 0;
        for (int flav: flav_day){
            if(flav <= min_day){
                adj_flav++;
                if(adj_flav == k){
                    cake++;
                    adj_flav = 0;
                }
            }else{
                adj_flav = 0;
            }

            if(cake > m){
                return true;
            }
        }
        return cake >= m;
    }

    public static void main(String args[]){
        int arr[] = {1, 10, 3, 10, 2};
        System.out.println(bake_cake(arr, 1, 3));
    }
}
