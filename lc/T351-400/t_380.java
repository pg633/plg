package leetcoder;


import java.util.*;


class RandomizedSet {
    private Map<Integer,Integer> hash = new HashMap<>();
    private List<Integer> arr = new ArrayList<>();
    public RandomizedSet() {
    }
    public boolean insert(int val) {
        if(hash.containsKey(val))return false;
        hash.put(val,arr.size());
        arr.add(val);
        return true;
    }
    public boolean remove(int val) {
        if(!hash.containsKey(val)) return false;
        Integer integer = hash.get(val);
        {
            int dd = arr.get(arr.size()-1);
            arr.set(integer , arr.get(arr.size()-1));
            arr.remove(arr.size()-1);
            hash.put(dd,integer);
        }
        hash.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        if(arr.size() == 0)return 0;
        else return arr.get(new Random().nextInt(arr.size()));
    }
}


public class AAA {
    public static void main(String[] args) {
        RandomizedSet s = new RandomizedSet();
        s.insert(1);
        System.out.println(s.getRandom());
        s.insert(2);
        System.out.println(s.getRandom());
        s.remove(2);
        s.remove(1);
        System.out.println(s.getRandom());

    }
}
