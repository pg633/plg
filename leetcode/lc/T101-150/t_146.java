package leetcoder;


import java.util.*;
class LRUCache {

    public LRUCache(int capacity) {
        lru = new leetcoder.LRUCache.LRU(capacity);
    }

    public int get(int key) {
        if(lru.containsKey(key)){
            return lru.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        lru.put(key,value);
    }
    private leetcoder.LRUCache.LRU lru;
    class LRU extends LinkedHashMap<Integer,Integer>{
        int capacity;
        public LRU(int initialCapacity) {
            super(initialCapacity,0.75f,true);
            this.capacity = initialCapacity;

        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return this.capacity < this.size();
        }
    }

}


public class Main {

    public static void main(String[] arg) {


    }

}