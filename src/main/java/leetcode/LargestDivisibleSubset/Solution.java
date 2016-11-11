package leetcode.LargestDivisibleSubset;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ymyue on 7/16/16.
 * Time complexity: O(n^2)
 * Space complexity: O(n)
 */
public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] count = new int[n];
        Arrays.fill(count, 1);
        int maxCount = 1;
        for (int i = 1; i < n; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0)
                    count[i] = Math.max(count[i], count[j]+1);
            }
            maxCount = Math.max(maxCount, count[i]);
        }
        List<Integer> result = new LinkedList<>();
        int val = 0;
        for (int i = n-1; i >= 0; i--) {
            if (count[i] == maxCount && val % nums[i] == 0) {
                result.add(0, nums[i]);
                maxCount--;
                val = nums[i];
            }
        }
        return result;
    }
}
