package leetcode.FindMedianfromDataStream;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by ymyue on 10/20/16.
 */
public class MedianFinder {
    Queue<Integer> smaller = new PriorityQueue<>(Collections.reverseOrder());
    Queue<Integer> larger = new PriorityQueue<>();

    // Adds a number into the data structure.
    public void addNum(int num) {
        if (smaller.isEmpty() || num <= smaller.peek())
            smaller.offer(num);
        else
            larger.offer(num);
        if (smaller.size() < larger.size())
            smaller.offer(larger.poll());
        else if (smaller.size() > larger.size()+1)
            larger.offer(smaller.poll());
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (smaller.size() == larger.size())
            return ((double)smaller.peek() + larger.peek()) / 2.0;
        else
            return smaller.peek();
    }
}
