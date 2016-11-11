package leetcode.LongestConsecutiveSequence;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ymyue on 6/20/16.
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Solution2 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);
        int maxCount = 0;
        for (int num : nums) {
            if (set.contains(num)) {
                int count = 1;
                set.remove(num);
                int p = num+1;
                while (set.remove(p)) {
                    count++;
                    p++;
                }
                p = num-1;
                while (set.remove(p)) {
                    count++;
                    p--;
                }
                maxCount = Math.max(maxCount, count);
            }
        }
        return maxCount;
    }
}
