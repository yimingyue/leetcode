package leetcode.SingleNumber;

/**
 * Created by ymyue on 6/6/16.
 */
public class Solution2 {
    public int singleNumber(int[] nums) {
        assert(nums.length > 0);
        int result = 0;
        for (int num : nums)
            result ^= num;
        return result;
    }
}
