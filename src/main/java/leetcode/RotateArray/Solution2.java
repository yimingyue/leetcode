package leetcode.RotateArray;

/**
 * Created by ymyue on 6/21/16.
 * Time complexity: O(n)
 * Space complexity: O(k)
 */
public class Solution2 {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return;
        int n = nums.length;
        k %= n;
        int[] tmp = new int[k];
        for (int i = n-1; i >= 0; i--) {
            int j = i + k;
            if (j >= n)
                tmp[j%n] = nums[i];
            else
                nums[j] = nums[i];
        }
        for (int i = 0; i < k; i++)
            nums[i] = tmp[i];
    }
}
