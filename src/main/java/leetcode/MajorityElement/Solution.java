package leetcode.MajorityElement;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/24/14
 * Time: 11:46 AM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int n = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                n = nums[i];
                count++;
            } else if (nums[i] == n)
                count++;
            else {
                count--;
            }
        }
        return n;
    }
}

/*
Keypoints:
 1) the majority element appears more than [n/2] times. Hence, if omit every pair of different element, the left ones must be the majority elements.
*/