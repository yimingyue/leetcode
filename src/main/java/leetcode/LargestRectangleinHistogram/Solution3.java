package leetcode.LargestRectangleinHistogram;

import java.util.Stack;

/**
 * Created by ymyue on 6/21/15.
 */
public class Solution3 {
    public int largestRectangleArea(int[] height) {
        int[] heights = new int[height.length + 1];
        for (int i = 0; i < height.length; i++)
            heights[i] = height[i];
        heights[heights.length-1] = 0;
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            if (stack.isEmpty())
                stack.push(i);
            else {
                int j = stack.peek();
                int h = heights[j];
                if (h < heights[i])
                    stack.push(i);
                else {
                    while (h >= heights[i]) {
                        j = stack.pop();
                        int area = 0;
                        if (!stack.isEmpty()) {
                            area = h * (i - stack.peek()-1);
                        } else {
                            area = h * i;
                        }
                        max = Math.max(max, area);
                        if (stack.isEmpty())
                            break;
                        j = stack.peek();
                        h = heights[j];
                    }
                    stack.push(i);
                }
            }
        }
        return max;
    }
}
