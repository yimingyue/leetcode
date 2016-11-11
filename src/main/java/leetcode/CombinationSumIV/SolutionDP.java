package leetcode.CombinationSumIV;

import java.util.Arrays;

/**
 * Created by ymyue on 7/25/16.
 * Time complexity: O(nk)
 * Space complexity: O(n)
 */
public class SolutionDP {
    public int combinationSum4(int[] nums, int target) {
        int[] res = new int[target + 1];
        res[0] = 1;
        Arrays.sort(nums);
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num > i)
                    break;
                res[i] += res[i-num];
            }
        }
        return res[target];
    }
}
