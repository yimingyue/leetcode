package leetcode.FindKPairswithSmallestSums;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymyue on 7/28/16.
 * Time complexity: O(kn)
 * Space complexity: O(n)
 */
public class Solution2 {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[] idx = new int[n];
        List<int[]> result = new ArrayList<>();

        while (result.size() < k) {
            int minIdx = -1;
            for (int i = 0; i < nums1.length; i++) {
                if (idx[i] < nums2.length)
                    minIdx = (minIdx == -1 || (nums1[minIdx] + nums2[idx[minIdx]]) > (nums1[i] + nums2[idx[i]])) ? i : minIdx;
            }
            if (minIdx == -1)
                break;
            result.add(new int[] {nums1[minIdx], nums2[idx[minIdx]]});
            idx[minIdx]++;
        }
        return result;
    }
}
