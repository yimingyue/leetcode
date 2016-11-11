package leetcode.CreateMaximumNumber;

import leetcode.common.utils.Utils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by ymyue on 7/17/16.
 */
public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] result = new int[k];
        for (int i = Math.max(0, k - nums2.length); i <= Math.min(k, nums1.length); i++) {
            int[] sub1 = maxNumber(nums1, i);
            int[] sub2 = maxNumber(nums2, k-i);
            int[] maxNum = merge(sub1, sub2);
            result = compare(result, maxNum);
        }
        Utils.print(result);
        return result;
    }

    private int[] maxNumber(int[] nums, int k) {
        int i = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        while (i < nums.length) {
            while (!stack.isEmpty() && nums[i] > stack.peek() && stack.size() + nums.length - i > k)
                stack.pop();
            if (stack.size() < k)
                stack.push(nums[i]);
            i++;
        }
        int[] result = new int[k];
        i = k-1;
        while (i >= 0)
            result[i--] = stack.pop();
        return result;
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int k = 0;
        int i = 0;
        int j = 0;
        int[] result = new int[nums1.length + nums2.length];
        while (k < nums1.length + nums2.length) {
            if (j == nums2.length || (i != nums1.length && nums1[i] > nums2[j]))
                result[k++] = nums1[i++];
            else if (i == nums1.length || nums1[i] < nums2[j])
                result[k++] = nums2[j++];
            else {
                int count = 0;
                int x = i;
                int y = j;
                result[k++] = nums1[i];
                while (x < nums1.length && y < nums2.length && nums1[x] == nums2[y]) {
                    x++;
                    y++;
                }
                if (x == nums1.length) {
                    j++;
                }
                else if (y == nums2.length) {
                    i++;
                }
                else if (nums1[x] > nums2[y]) {
                    i++;
                }
                else {
                    j++;
                }
            }
        }
        return result;
    }

    private int[] compare(int[] nums1, int[] nums2) {
        int i = 0;
        while (i < nums1.length) {
            if (nums1[i] > nums2[i])
                return nums1;
            else if (nums1[i] < nums2[i])
                return nums2;
            i++;
        }
        return nums1;
    }
}
