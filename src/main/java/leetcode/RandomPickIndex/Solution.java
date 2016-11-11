package leetcode.RandomPickIndex;

import java.util.Random;

/**
 * Created by ymyue on 9/24/16.
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Solution {
    int[] nums;
    Random random;
    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    public int pick(int target) {
        int result = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (random.nextInt(++count) == 0)
                    result = i;
            }
        }
        return result;
    }
}
