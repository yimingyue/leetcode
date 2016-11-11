package leetcode.DesignPhoneDirectory;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * Created by ymyue on 9/28/16.
 * Time complexity: O(1)
 * Space complexity: O(n)
 */
public class PhoneDirectory {
    Set<Integer> used;
    Queue<Integer> released;
    int counter;
    int size;
    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        this.size = maxNumbers;
        this.counter = 0;
        used = new HashSet<>();
        released = new ArrayDeque<>();
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        int val = -1;
        if (counter < size)
            val = counter++;
        else if (!released.isEmpty())
            val = released.poll();
        if (val != -1)
            used.add(val);
        return val;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return !used.contains(number);
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if (used.remove(number))
            released.offer(number);
    }
}
