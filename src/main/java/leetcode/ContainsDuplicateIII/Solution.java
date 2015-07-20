package leetcode.ContainsDuplicateIII;

import java.util.*;

/**
 * Created by ymyue on 6/7/15.
 */
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0)
            return false;
        if (k <= 0 || t < 0)
            return false;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                List<Integer> list = map.get(nums[i]);
                list.add(i);
            } else {
                List<Integer> list = new ArrayList<> ();
                map.put(nums[i], list);
                list.add(i);
            }
        }
        Arrays.sort(nums);
        int i = 1, j = 0;
        while (i < nums.length) {
            while (nums[i] - nums[j] > t)
                j++;
            for (int l = j; l < i; l++) {
                if (nums[i] == nums[l]) {
                    if (maxDiffWithinK(map.get(nums[i]), k))
                        return true;
                } else if (nums[l] + t >= nums[i]) {
                    if (maxDiffWithinK(map.get(nums[i]), map.get(nums[l]), k))
                        return true;
                }
            }
            i++;
        }
        return false;
    }

    private boolean maxDiffWithinK(List<Integer> list, int k) {
        if (list == null || list.size() <= 1)
            return false;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) - list.get(i-1) <= k)
                return true;
        }
        return false;
    }

    private boolean maxDiffWithinK(List<Integer> list1, List<Integer> list2, int k) {
        if (list1 == null || list1.size() == 0)
            return false;
        if (list2 == null || list2.size() == 0)
            return false;
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            int m = list1.get(i);
            int n = list2.get(j);
            if (Math.abs(m - n) <= k)
                return true;
            if (m < n)
                i++;
            else
                j++;
        }
        return false;
    }
}
