package leetcode.LoggerRateLimiter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ymyue on 7/25/16.
 * Time complexity: O(n)
 * Space complexity: O(k) k is the unique number of messages
 */
public class Logger2 {
    Map<String, Integer> map = new HashMap<>();
    /** Initialize your data structure here. */
    public Logger2() {

    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (timestamp >= map.getOrDefault(message, -10) + 10) {
            map.put(message, timestamp);
            return true;
        }
        return false;
    }
}
