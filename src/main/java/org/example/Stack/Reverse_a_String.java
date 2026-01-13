package org.example.Stack;

import java.util.Stack;

public class Reverse_a_String {
    public static String reverse(String str){
        int n = str.length();
        char [] arr = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char i: arr){
            stack.push(i);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append(stack.pop());
        }
        return sb.toString();
    }
    public static void main(String args[]){
        System.out.println(reverse("Pratik"));
    }
}
