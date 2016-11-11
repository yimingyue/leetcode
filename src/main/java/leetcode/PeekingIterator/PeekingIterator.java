package leetcode.PeekingIterator;

import java.util.Iterator;

/**
 * Created by ymyue on 7/9/16.
 * Time complexity:
 *  - peek: O(1)
 *  - next: O(1)
 *  - hasNext: O(1)
 * Space complexity:
 *  - O(1)
 */
public class PeekingIterator<E> implements Iterator<E> {
    private E next = null;
    private final Iterator<? extends E> iterator;
    public PeekingIterator(Iterator<? extends E> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        if (iterator.hasNext())
            next = iterator.next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public E peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public E next() {
        E tmp = next;
        next = iterator.hasNext() ? iterator.next() : null;
        return tmp;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }
}
