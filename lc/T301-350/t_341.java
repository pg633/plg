package leetcoder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

class NestedIterator implements Iterator<Integer> {
    private List<Integer> list = new ArrayList<>();
    private int index = 0;
    public NestedIterator(List<NestedInteger> nestedList) {
        add(nestedList);


    }

    private void add(List<NestedInteger> nestedList) {
        for (NestedInteger nestedInteger : nestedList) {
            if(nestedInteger.isInteger()){
                list.add(nestedInteger.getInteger());
            }else {
                add(nestedInteger.getList());
            }
        }

    }

    @Override
    public Integer next() {
        return list.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index<list.size();
    }
}

public class AAA {
    public static void main(String[] args) {

    }
}
