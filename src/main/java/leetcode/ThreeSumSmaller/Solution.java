package leetcode.ThreeSumSmaller;

import java.util.Arrays;

/**
 * Created by ymyue on 10/20/16.
 */
public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            int j = i+1;
            int k = nums.length-1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] < target) {
                    count += k-j;
                    j++;
                } else
                    k--;
            }
        }
        return count;
    }
}
