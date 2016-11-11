package leetcode.MinStack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by ymyue on 7/8/16.
 */
public class MinStack2 {
    Deque<Integer> deque = new ArrayDeque<>();
    Deque<Integer> minDeque = new ArrayDeque<> ();
    /** initialize your data structure here. */
    public MinStack2() {

    }

    public void push(int x) {
        deque.push(x);
        if (minDeque.isEmpty() || x <= minDeque.peek())
            minDeque.push(x);
    }

    public void pop() {
        int val = deque.pop();
        if (minDeque.peek() == val)
            minDeque.pop();
    }

    public int top() {
        return deque.peek();
    }

    public int getMin() {
        return minDeque.peek();
    }
}
