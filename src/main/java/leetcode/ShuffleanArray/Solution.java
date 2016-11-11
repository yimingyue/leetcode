package leetcode.ShuffleanArray;

import java.util.Random;

/**
 * Created by ymyue on 9/18/16.
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Solution {
    int[] nums;
    Random random = new Random();
    public Solution(int[] nums) {
        this.nums = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums.clone();
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] shuffle = nums.clone();
        for (int i = 0; i < shuffle.length; i++) {
            int r = random.nextInt(shuffle.length - i);
            swap(shuffle, i, i + r);
        }
        return shuffle;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
