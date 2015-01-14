package leetcode.LargestRectangleinHistogram;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/25/14
 * Time: 11:54 AM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public int largestRectangleArea(int[] height) {
        if (height.length == 0)
            return 0;
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            left[i] = 0;
            right[i] = n-1;
        }

        Stack<Integer> stack = new Stack<> ();
        int offset = 0;
        for (int i = 1; i < n; i++) {
            if (height[i] > height[i-1]) {
                stack.push(i-1);
                left[i] = i;
            } else {
                while (!stack.isEmpty()) {
                    offset = stack.peek();
                    if (height[i] > height[offset]) {
                        left[i] = offset+1;
                        break;
                    }
                    stack.pop();
                }
            }
        }

        offset = n-1;
        stack.clear();
        for (int i = n-2; i >= 0; i--) {
            if (height[i] > height[i+1]) {
                stack.push(i+1);
                right[i] = i;
            } else {
                while (!stack.isEmpty()) {
                    offset = stack.peek();
                    if (height[i] > height[offset]) {
                        right[i] = offset-1;
                        break;
                    }
                    stack.pop();
                }
            }
        }

        int max = 0;
        int area = 0;
        for (int i = 0; i < height.length; i++) {
            area = (right[i]-left[i]+1) * height[i];
            max = Math.max(area, max);
        }
        return max;
    }
}
