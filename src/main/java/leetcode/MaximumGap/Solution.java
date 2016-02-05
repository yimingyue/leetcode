package leetcode.MaximumGap;

import java.util.Arrays;

/**
 * Created by ymyue on 1/18/16.
 */
public class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;
        int low = nums[0];
        int high = nums[0];
        for (int num : nums) {
            low = Math.min(low, num);
            high = Math.max(high, num);
        }
        int n = nums.length;
        int[] maxArr = new int[n+1];
        int[] minArr = new int[n+1];
        Arrays.fill(maxArr, -1);
        Arrays.fill(minArr, -1);
        minArr[n] = high;
        maxArr[0] = low;
        int width = (high - low) / n + 1;
        for (int num : nums) {
            if (num != high && num != low) {
                int i = (num - low) / width;
                maxArr[i] = maxArr[i] == -1 ? num : Math.max(maxArr[i], num);
                minArr[i] = minArr[i] == -1 ? num : Math.min(minArr[i], num);
            }
        }
        int i = 0;
        int maxDiff = 0;
        while (i < n) {
            if (maxArr[i] == -1)
                i++;
            else {
                int j = i+1;
                while (j < n+1 && minArr[j] == -1)
                    j++;
                if (j < n+1) {
                    maxDiff = Math.max(maxDiff, minArr[j] - maxArr[i]);
                }
                i = j;
            }
        }
        return maxDiff;
    }
}
