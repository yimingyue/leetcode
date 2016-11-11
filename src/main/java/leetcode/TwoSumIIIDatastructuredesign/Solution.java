package leetcode.TwoSumIIIDatastructuredesign;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ymyue on 6/12/16.
 * Time complexity:
 *  - add: O(1)
 *  - find: O(n)
 */
public class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    // Add the number to an internal data structure.
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        for (int key : map.keySet()) {
            if (map.containsKey(value - key)) {
                if (value - key != key || map.get(key) > 1)
                    return true;
            }
        }
        return false;
    }
}
