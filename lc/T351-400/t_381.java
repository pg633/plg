package leetcoder;


import java.util.*;

class RandomizedCollection {

    private Map<Integer,List<Integer>> m = new HashMap<>();
    private List<Integer> v = new ArrayList<>();
    public RandomizedCollection() {

    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if(m.containsKey(val)){
            m.get(val).add(v.size());
        }
        else {
            List<Integer> tmpList = new ArrayList<>();
            tmpList.add(v.size());
            m.put(val,tmpList);
        }
        v.add(val);
        return true;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!m.containsKey(val) || m.get(val).size()==0){
            return false;
        }
        {
            int id = m.get(val).get(m.get(val).size()-1);
            int dd = v.get(v.size()-1);
            v.set(id,dd);
            m.get(dd).set(m.get(dd).indexOf(v.size() - 1),id);
            v.remove(v.size()-1);
            m.get(val).remove(m.get(val).indexOf(id));
            return true;
        }
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        if(v.size() == 0) return 0;
        return v.get(new Random().nextInt(v.size()));
    }
}

public class AAA {
    public static void main(String[] args) {
        RandomizedCollection s = new RandomizedCollection();
        s.insert(1);
        s.insert(2);
        s.insert(1);
        s.remove(1);
        s.remove(1);
        System.out.println(s.getRandom());
        System.out.println(s.getRandom());
        System.out.println(s.getRandom());


    }
}
