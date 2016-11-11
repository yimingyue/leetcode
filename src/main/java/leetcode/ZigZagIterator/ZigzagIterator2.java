package leetcode.ZigZagIterator;

import java.util.*;

/**
 * Created by ymyue on 10/20/16.
 */
public class ZigzagIterator2 {
    Queue<Iterator> queue;
    public ZigzagIterator2(List<Integer> v1, List<Integer> v2) {
        queue = new ArrayDeque<>();
        if (!v1.isEmpty())
            queue.offer(v1.iterator());
        if (!v2.isEmpty())
            queue.offer(v2.iterator());
    }

    public int next() {
        Iterator<Integer> iter = queue.poll();
        int result = iter.next();
        if (iter.hasNext())
            queue.offer(iter);
        return result;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
