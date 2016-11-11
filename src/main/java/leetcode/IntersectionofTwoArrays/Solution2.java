package leetcode.IntersectionofTwoArrays;

import java.util.Arrays;

import static java.util.stream.Collectors.toSet;

/**
 * Created by ymyue on 6/4/16.
 * java 8 version
 * Time complexity O(m+n)
 * Space complexity O(n)
 */
public class Solution2 {
    public int[] intersection(int[] nums1, int[] nums2) {
        return Arrays.stream(nums1).filter(Arrays.stream(nums2).boxed().collect(toSet())::contains).distinct().toArray();
    }
}
