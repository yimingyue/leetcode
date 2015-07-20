package leetcode.ContainerWithMostWater;

import java.util.Stack;

/**
 * Created by ymyue on 6/7/15.
 */
public class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2)
            return 0;
        Stack<Integer> leftStack = new Stack<> ();
        Stack<Integer> rightStack = new Stack<> ();
        for (int i = 0; i < height.length; i++) {
            if (leftStack.isEmpty()){
                leftStack.push(i);
            } else {
                int j = leftStack.peek();
                if (height[i] > height[j])
                    leftStack.push(i);
            }
            if (rightStack.isEmpty()) {
                rightStack.push(i);
            } else {
                int j = rightStack.peek();
                while (height[i] >= height[j]) {
                    rightStack.pop();
                    if (rightStack.isEmpty())
                        break;
                    j = rightStack.peek();
                }
                rightStack.push(i);
            }
        }
        Stack<Integer> reverseStack = new Stack<> ();
        while (!rightStack.isEmpty())
            reverseStack.push(rightStack.pop());
        int left = leftStack.pop();
        int right = reverseStack.pop();
        int max = (right - left) * height[left];
        while (!leftStack.isEmpty() || !reverseStack.isEmpty()) {
            if (!leftStack.isEmpty() && !reverseStack.isEmpty()) {
                int leftHeight = height[leftStack.peek()];
                int rightHeight = height[reverseStack.peek()];
                if (leftHeight == rightHeight) {
                    left = leftStack.pop();
                    right = reverseStack.pop();
                } else if (leftHeight < rightHeight) {
                    right = reverseStack.pop();
                } else {
                    left = leftStack.pop();
                }
            }
            else if (reverseStack.isEmpty()) {
                    left = leftStack.pop();
            } else {
                    right = reverseStack.pop();
            }
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
        }
        return max;
    }
}
