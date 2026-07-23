package org.example.Stack_and_Queue;

import java.util.Stack;

public class Reverse_Substring_Bracket {
    public static String reverse_substring(String nums, int n){
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char num: nums.toCharArray()){
            if(num == ')'){
                while (!stack.isEmpty() && stack.peek() != '('){
                    sb.append(stack.pop());
                }

                if(!stack.isEmpty()) stack.pop();

                for (char c : sb.toString().toCharArray()){
                    stack.push(c);
                }

                sb.setLength(0);
            }else{
                stack.push(num);
            }
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()){
            res.append(stack.pop());
        }

        return res.reverse().toString();
    }

    public static void main(String args[]){
        System.out.println(reverse_substring("(accio(job))", 12));
    }
}
