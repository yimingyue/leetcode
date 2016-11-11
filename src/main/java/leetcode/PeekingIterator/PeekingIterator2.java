package leetcode.PeekingIterator;

import java.util.Iterator;

/**
 * Created by ymyue on 10/20/16.
 */
public class PeekingIterator2 implements Iterator<Integer> {
    Integer next;
    Iterator<Integer> iter;
    public PeekingIterator2(Iterator<Integer> iterator) {
        // initialize any member here.
        this.next = null;
        this.iter = iterator;

    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (next != null)
            return next;
        next = iter.next();
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int val = next == null ? iter.next() : next;
        next = null;
        return val;
    }

    @Override
    public boolean hasNext() {
        return next != null || iter.hasNext();
    }
}
