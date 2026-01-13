package org.example.Stack;

import java.util.Stack;

public class Balanced_Parentheses {
    public static boolean valid_Parenthesis(String str){

        Stack<Character> stack = new Stack<>();

        for(char s: str.toCharArray()){
            if((s == '(') || (s == '[') || (s == '{')){
                stack.push(s);
            } else if (stack.isEmpty()) {
                return false;
            } else if (
                    ((stack.peek() == '(') && (s == ')')) ||
                    ((stack.peek() == '[') && (s == ']')) ||
                            ((stack.peek() == '{') && (s == '}'))
            ) {
                stack.pop();
            }
            else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String args[]){
        System.out.println(valid_Parenthesis("{}[]()"));
    }
}
