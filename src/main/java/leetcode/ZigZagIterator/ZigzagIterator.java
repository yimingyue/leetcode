package leetcode.ZigZagIterator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ymyue on 7/8/16.
 * Space complexity: O(k)
 */
public class ZigzagIterator {
    Deque<Iterator<Integer>> queue = new ArrayDeque<>();

    // O(k)
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        if (v1.iterator().hasNext())
            queue.offer(v1.iterator());
        if (v2.iterator().hasNext())
            queue.offer(v2.iterator());
    }

    // O(1)
    public int next() {
        Iterator<Integer> iter = queue.poll();
        int val = iter.next();
        if (iter.hasNext())
            queue.offer(iter);
        return val;
    }

    // O(1)
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
