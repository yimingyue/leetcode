package leetcode.FirstMissingPositive;

/**
 * Created by ymyue on 6/23/16.
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i]-1 != i) {
                if (nums[i] < 1 || nums[i] > nums.length || nums[nums[i]-1] == nums[i])
                    break;
                int tmp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = tmp;
            }
        }
        int i = 0;
        while (i < nums.length) {
            if (i != nums[i]-1)
                break;
            i++;
        }
        return i+1;
    }
}
