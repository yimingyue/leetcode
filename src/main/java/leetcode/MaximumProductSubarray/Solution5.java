package leetcode.MaximumProductSubarray;

/**
 * Created by ymyue on 6/22/16.
 * https://leetcode.com/discuss/14235/possibly-simplest-solution-with-o-n-time-complexity
 */
public class Solution5 {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int maxProduct = nums[0];
        int iMax = nums[0];
        int iMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = iMax;
                iMax = iMin;
                iMin = tmp;
            }
            iMax = Math.max(nums[i], iMax*nums[i]);
            iMin = Math.min(nums[i], iMin*nums[i]);
            maxProduct = Math.max(maxProduct, iMax);
        }
        return maxProduct;
    }
}
