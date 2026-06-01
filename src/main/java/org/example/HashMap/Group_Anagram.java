package org.example.HashMap;

import java.util.*;

public class Group_Anagram {
    public static String group_anagram(String str[]){
        Map<String, List<String>> map = new HashMap<>();
        for(String word: str){
            String curr = get_word(word);
            if(!map.containsKey(curr)){
                map.put(curr, new ArrayList<>());
            }
            map.get(curr).add(word);
        }

        List<List<String>> ls_2d = new ArrayList<>(map.values());
        Collections.sort(ls_2d, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> g1, List<String> g2) {
                return g1.get(0).compareTo(g2.get(0));
            }
        });

        StringBuilder sb = new StringBuilder();
        for(List<String> ls: ls_2d){
            for(String word: ls){
                sb.append(word).append(" ");
            }
        }

        return sb.toString().trim();
    }

    public static String get_word(String word){
        char arr[] = word.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    public static void main(String args[]){
        String arr[] = {"cat", "dog", "tac", "god", "act"};
        System.out.println(group_anagram(arr));
    }
}
