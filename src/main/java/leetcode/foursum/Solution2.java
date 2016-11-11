package leetcode.FourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ymyue on 6/11/16.
 * Time complexity: O(n^3)
 * Space complexity: O(1)
 */
public class Solution2 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list= new ArrayList<>();
        if (nums == null || nums.length < 4)
            return list;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-3; i++) {
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            for (int j = i+1; j < nums.length-2; j++) {
                if (j > i+1 && nums[j] == nums[j-1])
                    continue;
                int k = j+1;
                int l = nums.length-1;
                int sum = nums[i] + nums[j];
                while (k < l) {
                    if (sum + nums[k] + nums[l] == target) {
                        List<Integer> tmp = new ArrayList<> (4);
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[k]);
                        tmp.add(nums[l]);
                        list.add(tmp);
                        k++;
                        l--;
                        while (k < l && nums[k] ==  nums[k-1])
                            k++;
                        while (k < l && nums[l] == nums[l+1])
                            l--;
                    } else if (sum + nums[k] + nums[l] < target)
                        k++;
                    else
                        l--;
                }
            }
        }
        return list;
    }
}
