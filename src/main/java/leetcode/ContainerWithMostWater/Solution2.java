package leetcode.ContainerWithMostWater;

/**
 * Created by ymyue on 6/21/16.
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Solution2 {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int i = 0;
        int j = height.length-1;
        while (i < j) {
            maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j])
                i++;
            else
                j--;
        }
        return maxArea;
    }
}
