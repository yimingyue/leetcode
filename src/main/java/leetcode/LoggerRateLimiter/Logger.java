package leetcode.LoggerRateLimiter;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * Created by ymyue on 7/25/16.
 * Time complexity: O(n)
 * Space complexity: O(10)
 */
public class Logger {
    Map<String, Integer> map = new HashMap<>();
    Queue<String> queue = new ArrayDeque<>();
    /** Initialize your data structure here. */
    public Logger() {

    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        while (!queue.isEmpty()) {
            if (map.get(queue.peek()) <= timestamp - 10) {
                map.remove(queue.poll());
            } else
                break;
        }
        if (!map.containsKey(message)) {
            queue.offer(message);
            map.put(message, timestamp);
            return true;
        }
        return false;
    }
}
