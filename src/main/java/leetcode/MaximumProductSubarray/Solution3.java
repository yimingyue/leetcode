package leetcode.MaximumProductSubarray;

/**
 * Created by ymyue on 6/22/16.
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Solution3 {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int i = 0;
        int j = 0;
        int product = 1;
        int maxProduct = nums[0];
        while (i < nums.length) {
            if (nums[i] == 0) {
                maxProduct = Math.max(maxProduct, 0);
                while (product < 0)
                    product /= nums[j++];
                if (j != i)
                    maxProduct = Math.max(maxProduct, product);
                j = i+1;
                product = 1;
            } else {
                product *= nums[i];
                maxProduct = Math.max(maxProduct, product);
            }
            i++;
        }
        while (product < 0)
            product /= nums[j++];
        if (j != i)
            maxProduct = Math.max(maxProduct, product);
        return maxProduct;
    }
}
