package leetcoder;

import java.util.Iterator;

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    private int k =0;
    private boolean flag = false;
    private Iterator<Integer> iterator;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;

    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if(flag){
            return k;
        }else{
            k = iterator.next();
            flag = true;
            return k;
        }
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if(flag) {
            flag = false;
            return k;
        }else {
            return iterator.next();
        }

    }

    @Override
    public boolean hasNext() {
        if(flag) return true;
        else return iterator.hasNext();
    }
}

public class Main {

    public static void main(String[] arg) {

    }

}

