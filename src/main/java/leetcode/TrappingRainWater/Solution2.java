package leetcode.TrappingRainWater;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/25/14
 * Time: 3:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution2 {
    public int trap(int[] A) {
        if (A.length < 3)
            return 0;
        Stack<Integer> stack = new Stack<> ();

        int total = 0;

        for (int i = 0; i < A.length; i++) {
            if (stack.isEmpty() || A[i] < A[stack.peek()])
                stack.push(i);
            else {
                int tmp = stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                    continue;
                }
                int left = stack.peek();
                if (A[left] <= A[i]) {
                    total += (A[left] - A[tmp]) * (i-left-1);
                    i--;
                } else {
                    total += (A[i] - A[tmp]) * (i - left -1);
                    stack.push(i);
                }
            }
        }
        return total;
    }
}
