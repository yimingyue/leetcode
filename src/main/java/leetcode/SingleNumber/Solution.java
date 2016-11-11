package leetcode.SingleNumber;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ymyue on 6/6/16.
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, (x, y) -> x - y);
        }
        for (int num : map.keySet()) {
            if (map.get(num) == 1)
                return num;
        }
        return 0;
    }
}
