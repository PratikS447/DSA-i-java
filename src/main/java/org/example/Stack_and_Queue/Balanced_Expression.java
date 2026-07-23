package org.example.Stack_and_Queue;

import java.util.Stack;

public class Balanced_Expression {
    public static boolean is_balanced(String str1){
        String str = str1.replaceAll("[^()\\[\\]\\{\\}]", "");
        System.out.println(str);
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '['){
                st.push(str.charAt(i));
            }else if(st.isEmpty()){
                return false;
            }else{
                if(st.peek() == '(' && str.charAt(i) == ')'  ||
                 st.peek() == '[' && str.charAt(i) == ']' ||
                 st.peek() == '{' && str.charAt(i) == '}' ){
                    st.pop();
                }
            }
        }
        return st.isEmpty();
    }
    public static void main(String args[]){
        System.out.println(is_balanced("[(a+b)+{(c+d)*(e/f)]}"));
    }
}
