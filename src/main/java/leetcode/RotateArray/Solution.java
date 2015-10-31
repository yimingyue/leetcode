package leetcode.RotateArray;

/**
 * Created by ymyue on 10/31/15.
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[(i+k)%nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++)
            nums[i] = arr[i];
    }
}
