package leetcoder;


import org.w3c.dom.Node;

import java.util.*;

class LFUCache {
    class node{
        int val;
        int key;
        int frequency;
        node next;
        node prev;
    }
    private int max =0 ;
    // 数据 节点
    HashMap<Integer,node> keyMap = new HashMap<>();
    node head = new node();
    HashMap<Integer,node> freMap = new HashMap<>();

    public LFUCache(int capacity) {
        max = capacity;
        head.next = head.prev = head;
        head.frequency = -1;
    }

    public int get(int key) {
        if(max == 0) return -1;
        if(!keyMap.containsKey(key)) return -1;
        node no = keyMap.get(key);
        delete(no);
        no.frequency++;
        insert(no);
        return no.val;
    }

    public void put(int key, int value) {
        if(max == 0)return;;
        if(keyMap.containsKey(key)){
            node no = keyMap.get(key);
            no.val = value;
            get(key);
            return;
        }else{
            if(max == keyMap.size())
                delete(head.prev);

            node no = new node();
            no.key = key;
            no.frequency = 1;
            no.val = value;
            insert(no);
        }

    }

    private void insert(node no) {
        if(no.frequency == 1){
            node temp = freMap.getOrDefault(1,head);
            prepend(temp,no);
        }else{
            node prev = no.prev;
            node temp = null;
            if(prev.frequency >no.frequency || prev.frequency ==-1){
                temp = prev;
                append(prev,no);
            }else{
                if(prev.frequency > 0){
                    temp = freMap.get(prev.frequency);
                    if(temp.prev.frequency == no.frequency)
                        temp = freMap.get(temp.prev.frequency);
                    else if(temp.prev.frequency < 0){
                        temp = head;
                    }
                }else{
                    temp = head;
                }
                if(temp.frequency > 0 )prepend(temp,no);
                else append(temp,no);
            }
        }
        freMap.put(no.frequency,no);
        keyMap.put(no.key,no);
    }

    private void append(node prev, node no) {
        no.prev = prev;
        no.next = prev.next;
        prev.next.prev = no;
        prev.next = no;
    }

    private void prepend(node temp, node no) {
        no.prev = temp.prev;
        no.next = temp;
        temp.prev.next = no;
        temp.prev = no;
    }

    private void delete(node no) {
        keyMap.remove(no.key);
        node prev = no.prev;
        node next = no.next;
        if(prev.frequency != no.frequency){
            if(next.frequency == no.frequency){
                freMap.put(no.frequency,next);
            }else{
                freMap.remove(no.frequency);
            }
        }
        prev.next = next;
        next.prev = prev;
    }
}






public class AAA {
    public static void main(String[] args) {

    }
}