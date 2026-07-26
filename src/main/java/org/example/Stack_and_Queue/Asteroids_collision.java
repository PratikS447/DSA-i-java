package org.example.Stack_and_Queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Asteroids_collision {
    public static List<Integer> collision(int asteroids[]){
        int n = asteroids.length;
        Stack<Integer> st = new Stack<>();
        for(int right = 0; right < n; right++){
            if(asteroids[right] > 0){
                st.push(asteroids[right]);
            }else{
                while (!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(asteroids[right])){
                    st.pop();
                }
                if(!st.isEmpty() && st.peek() > 0 && st.peek() == Math.abs(asteroids[right])){
                    st.pop();
                }else if(st.isEmpty() || st.peek() < 0){
                    st.push(asteroids[right]);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!st.isEmpty()){
            ans.add(0, st.pop());
        }
        return ans;
    }
}
