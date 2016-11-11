package leetcode.FlattenNestedListIterator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ymyue on 7/31/16.
 * Time complexity: O(n)
 * Space complexity: O(k)
 */
public class MyNestedIterator implements Iterator<Integer> {
    Deque<Iterator<NestedInteger>> stack;
    Integer next;
    Iterator<NestedInteger> iter;

    public MyNestedIterator(List<NestedInteger> nestedList) {
        this.stack = new ArrayDeque<>();
        this.next = null;
        this.iter = nestedList.iterator();
    }

    @Override
    public Integer next() {
        Integer rev = next;
        next = null;
        return rev;
    }

    @Override
    public boolean hasNext() {
        while (next == null) {
            if (iter.hasNext()) {
                NestedInteger val = iter.next();
                if (val.isInteger()) {
                    next = val.getInteger();
                } else {
                    stack.push(iter);
                    iter = val.getList().iterator();
                }
            } else {
                if (!stack.isEmpty())
                    iter = stack.pop();
                else
                    return false;
            }
        }
        return true;
    }
}
