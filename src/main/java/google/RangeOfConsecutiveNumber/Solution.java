package google.RangeOfConsecutiveNumber;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ymyue on 10/16/16.
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=205448&highlight=google
 * Question 4
 */
public class Solution {
    public int[] rangeOfConsecutivenumber(int[] array, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            if (map.containsKey(sum - target))
                return new int[] {map.get(sum-target), i};
            map.put(sum, i);
        }
        return null;
    }
}
