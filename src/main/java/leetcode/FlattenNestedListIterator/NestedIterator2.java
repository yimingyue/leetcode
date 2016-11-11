package leetcode.FlattenNestedListIterator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ymyue on 10/22/16.
 */
public class NestedIterator2 implements Iterator<Integer> {
    Deque<Iterator<NestedInteger>> stack;
    Integer val;
    public NestedIterator2(List<NestedInteger> nestedList) {
        stack = new ArrayDeque<>();
        stack.push(nestedList.iterator());
        val = null;
    }

    @Override
    public Integer next() {
        int ret = val;
        val = null;
        return ret;
    }

    @Override
    public boolean hasNext() {
        while (val == null) {
            if (stack.isEmpty())
                return false;
            if (!stack.peek().hasNext())
                stack.pop();
            else {
                NestedInteger integer = stack.peek().next();
                if (integer.isInteger())
                    val = integer.getInteger();
                else
                    stack.push(integer.getList().iterator());
            }
        }
        return true;
    }
}
