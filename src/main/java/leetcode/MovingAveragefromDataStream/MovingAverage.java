package leetcode.MovingAveragefromDataStream;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by ymyue on 10/21/16.
 */
public class MovingAverage {
    int size;
    double sum;
    Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        queue = new ArrayDeque<>();
        sum = 0.0;
    }

    public double next(int val) {
        sum += val;
        queue.offer(val);
        if (queue.size() > size)
            sum -= queue.poll();
        return sum / queue.size();
    }
}
