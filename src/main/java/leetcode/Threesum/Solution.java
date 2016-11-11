package leetcode.Threesum;

import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rList = new ArrayList<> ();
        if (nums == null || nums.length == 0)
            return rList;
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length) {
            int j = i+1;
            int k = nums.length-1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<> ();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    rList.add(list);
                    j++;
                    while (nums[j] == nums[j-1] && j < k)
                        j++;
                    k--;
                    while (nums[k] == nums[k+1] && j < k)
                        k--;
                } else if (sum < 0) {
                    j++;
                } else
                    k--;
            }
            i++;
            while (i < nums.length && nums[i] == nums[i-1])
                i++;
        }
        return rList;
    }
}