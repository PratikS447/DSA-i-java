package org.example.LinkedList;

import java.util.HashMap;
import java.util.Map;

class LRU_Node{
    int key, value;
    LRU_Node next;
    LRU_Node prev;
    LRU_Node(int key, int value){
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}

public class LRU_Cache {
    public Map<Integer, LRU_Node> map;
    public LRU_Node head;
    public LRU_Node tail;
    public int cap;
    public LRU_Cache(int cap){
        this.cap = cap;
        this.map = new HashMap<>();
        this.head = new LRU_Node(-1, -1);
        this.tail = new LRU_Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    void insert_At_head(LRU_Node newNode){
        LRU_Node temp = head.next;

        newNode.next = head.next;
        newNode.prev = head;

        head.next = newNode;
        temp.prev = newNode;
    }

    void remove(LRU_Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    int get(int key){
        if(!map.containsKey(key)) return -1;
        LRU_Node ele = map.get(key);
        remove(ele);
        insert_At_head(ele);
        return ele.value;
    }

    void put(int key, int value){
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        LRU_Node newNode = new LRU_Node(key, value);
        map.put(key, newNode);
        insert_At_head(newNode);
        if(map.size() > cap){
            LRU_Node lru = tail.prev;
            map.remove(lru.key);
            remove(lru);
        }
    }
}
