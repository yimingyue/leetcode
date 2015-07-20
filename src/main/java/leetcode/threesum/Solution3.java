package leetcode.threesum;

import java.util.*;

/**
 * Created by ymyue on 5/21/15.
 */
public class Solution3 {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> rSet = new HashSet<>();
        if (nums.length < 3)
            return new ArrayList<List<Integer>>(rSet);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            int target = 0 - nums[i];
            int j = i+1;
            int k = nums.length -1;
            while (j < k) {
                int sum = nums[j] + nums[k];
                if (sum == target) {
                    List<Integer> list = Arrays.asList(nums[i], nums[2], nums[3]);
                    rSet.add(list);
                    j++;
                    while (j < k && nums[j] == nums[j-1])
                        j++;
                    k--;
                    while (j < k && nums[k] == nums[k+1])
                        k--;
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return new ArrayList<List<Integer>> (rSet);
    }
}
