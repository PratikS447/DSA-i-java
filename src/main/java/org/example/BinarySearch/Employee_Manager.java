package org.example.BinarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Employee_Manager {
    public static void hierarchy(Map<String, String> emp){
        Map<String, List<String>> map = new HashMap<>();
        for(String str: emp.keySet()){
            map.put(str, new ArrayList<>());
        }

        for (String str: emp.keySet()){
            String ele = emp.get(str);
            if(ele.equals(str)) continue;
            map.get(ele).add(str);
        }

        for (String str: emp.keySet()){
            System.out.println(str + ":" +helper(str, map));
        }
    }

    public static int helper(String str, Map<String, List<String>> map){
        List<String> ls = map.get(str);
        if(ls.isEmpty()) return 0;
        int ans = ls.size();
        for (String i: ls){
            ans += helper(i, map);
        }
        return ans;
    }
    public static void main(String args[]){
        Map<String, String> map = new HashMap<>();
        map.put("a", "c");
        map.put("b", "c");
        map.put("c", "f");
        map.put("d", "e");
        map.put("e", "f");
        map.put("f", "f");
        hierarchy(map);
    }
}
