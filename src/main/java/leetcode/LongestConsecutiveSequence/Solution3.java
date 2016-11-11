package leetcode.LongestConsecutiveSequence;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ymyue on 10/20/16.
 */
public class Solution3 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);
        int maxCount = 0;
        for (int num : nums) {
            int high = num+1;
            while (set.remove(high))
                high++;
            int low = num-1;
            while (set.remove(low))
                low--;
            maxCount = Math.max(maxCount, high - low - 1);
        }
        return maxCount;
    }
}
