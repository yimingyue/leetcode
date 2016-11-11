package leetcode.SortTransformedArray;

/**
 * Created by ymyue on 7/27/16.
 */
public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] result = new int[nums.length];
        int index = a > 0 ? nums.length-1 : 0;
        int i = 0;
        int j = nums.length-1;
        for (int k = 0; k < nums.length; k++) {
            if (a > 0) {
                result[index--] = f(nums[i], a, b, c) < f(nums[j], a, b, c) ? f(nums[j--], a, b, c) : f(nums[i++], a, b, c);
            } else {
                result[index++] = f(nums[i], a, b, c) < f(nums[j], a, b, c) ? f(nums[i++], a, b, c) : f(nums[j--], a, b, c);
            }
        }
        return result;
    }

    private int f(int x, int a, int b, int c) {
        return a*x*x + b*x + c;
    }
}
