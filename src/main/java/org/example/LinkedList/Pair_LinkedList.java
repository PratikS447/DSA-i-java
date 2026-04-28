package org.example.LinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pair_LinkedList {
    public List<List<Integer>> pair_ll(Doubly_ll head, int target){
        // iterator from head
        Doubly_ll first = head;

        // iterator for traversing the dll
        Doubly_ll temp = head;
        while (temp.next != null){
            temp = temp.next;
        }

        // iterator for traversing from last
        Doubly_ll last = temp;
        List<List<Integer>> res = new ArrayList<>();
        while(last != null && first != null && first != last && last.next != first){
            int sum = first.data + last.data;
            if(sum == target){
                res.add(Arrays.asList(first.data, last.data));
                first = first.next;
                last = last.prev;
            }else if(sum > target){
                last = last.prev;
            }else {
                first = first.next;
            }
        }

        return res;
    }
}
