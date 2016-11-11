package leetcode.CombinationSumIV;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ymyue on 7/25/16.
 * Time complexity: O(nk)
 * Space complexity: O(n)
 */
public class SolutionMemorization {
    public int combinationSum4(int[] nums, int target) {
        return combinationSum4(nums, target, new HashMap<>());
    }

    private int combinationSum4(int[] nums, int target, Map<Integer, Integer> cache) {
        if (cache.containsKey(target))
            return cache.get(target);
        int count = 0;
        for (int num : nums) {
            if (num == target)
                count++;
            else if (num < target)
                count += combinationSum4(nums, target - num, cache);
        }
        cache.put(target, count);
        return count;
    }
}
