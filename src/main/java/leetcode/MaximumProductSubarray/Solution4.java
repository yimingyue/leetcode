package leetcode.MaximumProductSubarray;

/**
 * Created by ymyue on 6/22/16.
 * https://leetcode.com/discuss/19795/share-my-c-solution-maybe-is-the-simplest-solution
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Solution4 {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int maxProduct = nums[0];
        int n = nums.length;
        int frontProduct = 1;
        int backProduct = 1;
        for (int i = 0; i < n; i++) {
            frontProduct *= nums[i];
            backProduct *= nums[n-1-i];
            maxProduct = Math.max(maxProduct, Math.max(frontProduct, backProduct));
            frontProduct = frontProduct == 0 ? 1 : frontProduct;
            backProduct = backProduct == 0 ? 1 : backProduct;
        }
        return maxProduct;
    }
}
