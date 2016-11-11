package leetcode.SummaryRanges;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymyue on 6/23/16.
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return list;
        int start = 0;
        int end = 0;
        for (int i = 1; i <= nums.length; i++) {
            if (i == nums.length || nums[i] - nums[i-1] != 1) {
                list.add(getRange(nums, start, end));
                start = i;
            }
            end = i;
        }
        return list;
    }

    private String getRange(int[] nums, int s, int e) {
        if (s == e)
            return String.valueOf(nums[s]);
        else
            return "" + nums[s] + "->" + nums[e];
    }
}
