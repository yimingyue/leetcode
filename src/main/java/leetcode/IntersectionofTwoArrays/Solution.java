package leetcode.IntersectionofTwoArrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ymyue on 6/4/16.
 * Straight-forward solution using hashset
 * Time complexity: O(m+n)
 * Space complexity: O(n)
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null)
            return null;

        Set<Integer> set = new HashSet<>();
        for (int num : nums1)
            set.add(num);
        Set<Integer> intersection = new HashSet<> ();
        for (int num : nums2) {
            if (set.contains(num)) {
                intersection.add(num);
            }
        }
        int[] r = new int[intersection.size()];
        int i = 0;
        for (int num : intersection)
            r[i++] = num;
        return r;
    }
}
