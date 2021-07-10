package leetcoder;


import java.util.*;
class AllOne {

    class ListNode{
        int val ;
        String key;
        ListNode prev ;
        ListNode next;

        public ListNode( String key,int val) {
            this.val = val;
            this.key = key;
        }
        public void remove(){
            this.prev.next = this.next;
            this.next.prev = this.prev;
        }
    };
    class Bucket{
        ListNode head;
        ListNode tail;
        int num;

        public Bucket() {
            head = new ListNode("",0);
            tail = new ListNode("",0);
            head.next = tail;
            tail.prev = head;
            num = 0;
        }
        public void insertInteYable(ListNode list){
            list.next = head.next;
            head.next.prev = list;
            head.next = list;
            list.prev = head;
            this.num++;
        }
    };

    private Map<String,ListNode> m ;
    private TreeMap<Integer,Bucket> tree;
    public AllOne() {
        m = new HashMap<>();
        tree = new TreeMap();

    }
    public void inc(String key) {
        // 有 key
        if(m.containsKey(key)){
            int val = m.get(key).val;
            m.get(key).remove();
            tree.get(val).num --;
            if(tree.get(val).num ==0){
                tree.remove(val);
            }
            val++;
            m.get(key).val = val;
            if(tree.containsKey(val)){
                tree.get(val).insertInteYable(m.get(key));
            }else{
                tree.put(val,new Bucket());
                tree.get(val).insertInteYable(m.get(key));
            }
        }else {
            m.put(key,new ListNode(key,1));
            if(tree.containsKey(1)){
                tree.get(1).insertInteYable(m.get(key));
            }else{
                tree.put(1,new Bucket());
                tree.get(1).insertInteYable(m.get(key));
            }
        }
    }

    public void dec(String key) {
        if(m.containsKey(key)){
            int val = m.get(key).val;
            m.get(key).remove();
            tree.get(val).num--;
            if(tree.get(val).num ==0){
                tree.remove(val);
            }
            val--;
            if(val==0) m.remove(key);
            else{
                m.get(key).val = val;
                if(tree.containsKey(val)){
                    tree.get(val).insertInteYable(m.get(key));
                }else{
                    tree.put(val,new Bucket());
                    tree.get(val).insertInteYable(m.get(key));
                }
            }

        }
    }

    public String getMaxKey() {
        if(tree.isEmpty())return "";
        return tree.get(tree.lastKey()).head.next.key;
    }

    public String getMinKey() {

        if(tree.isEmpty())return "";
        return tree.get(tree.firstKey()).head.next.key;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */

public class AAA {
    public static void main(String[] args) {
        AllOne obj = new AllOne();
        obj.inc("hello");
        obj.inc("goodbye");
        obj.inc("hello");
        obj.inc("hello");
        System.out.println(obj.getMaxKey());
        obj.inc("leet");
        obj.inc("code");
        obj.inc("leet");

        obj.dec("hello");
        obj.inc("leet");
        obj.inc("code");
        obj.inc("code");
        System.out.println(obj.getMaxKey());
    }
}
