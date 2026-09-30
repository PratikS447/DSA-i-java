package org.example.Expand_Around_Center;

public class Longest_Palindrom_substring {

    public static String longest_substring(String str){
        if(str.length() < 2){
            return str;
        }

        int start = 0;
        int maxLen = 0;
        for (int i = 0; i < str.length(); i++){
            int odd = expand(str, i, i); // odd
            int even = expand(str, i, i+1); // even

            int len = Math.max(odd, even);

            if(maxLen < len){
                maxLen = len;
                start = i - (len -1)/2;
            }
        }

        return str.substring(start, start + maxLen);
    }

    public static int expand(String str, int left, int right){
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)){
            left--;
            right++;
        }

        return right -left -1;
    }

}
