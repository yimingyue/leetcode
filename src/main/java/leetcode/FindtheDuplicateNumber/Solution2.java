package leetcode.FindtheDuplicateNumber;

/**
 * Created by ymyue on 6/26/16.
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Solution2 {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length < 2)
            throw new IllegalArgumentException();
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
