package leetcode.IntersectionofTwoArraysII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ymyue on 6/5/16.
 * Sort and two pointers solution
 * Time Complexity: O(Max(m, n)log(Max(m, n)))
 * Space Complexity: O(M + N)
 */
public class Solution2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> list = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j])
                i++;
            else if (nums1[i] > nums2[j])
                j++;
            else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] result = new int[list.size()];
        i = 0;
        for (int num : list)
            result[i++] = num;
        return result;
    }
}
