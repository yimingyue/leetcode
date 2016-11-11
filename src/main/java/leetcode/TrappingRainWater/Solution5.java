package leetcode.TrappingRainWater;

/**
 * Created by ymyue on 10/20/16.
 */
public class Solution5 {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length-1;
        int hl = 0;
        int hr = 0;
        int water = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                water += Math.max(0, hl - height[left]);
                hl = Math.max(hl, height[left]);
                left++;
            } else {
                water += Math.max(0, hr - height[right]);
                hr = Math.max(hr, height[right]);
                right--;
            }
        }
        return water;
    }
}
