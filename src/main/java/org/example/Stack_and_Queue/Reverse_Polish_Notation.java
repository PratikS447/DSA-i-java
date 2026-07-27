package org.example.Stack_and_Queue;

import java.util.Stack;

public class Reverse_Polish_Notation {
    public static int eval_RNP(String[] tokens){
        Stack<Integer> st = new Stack<>();
        int n = tokens.length;
        for(int right = 0; right < n; right++){
            if(tokens[right].equals("+")){
                int first = st.pop();
                int second = st.pop();
                st.push(second +first);
            }else if(tokens[right].equals("-")){
                int first = st.pop();
                int second = st.pop();
                st.push(second -first);
            }else if(tokens[right].equals("*")){
                int first = st.pop();
                int second = st.pop();
                st.push(second *first);
            }else if(tokens[right].equals("/")){
                int first = st.pop();
                int second = st.pop();
                st.push(second /first);
            }else{
                int curr = Integer.parseInt(tokens[right]);
                st.push(curr);
            }
        }
        return st.peek();
    }
}
