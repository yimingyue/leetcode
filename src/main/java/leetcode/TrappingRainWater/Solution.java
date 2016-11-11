package leetcode.TrappingRainWater;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 4/25/14
 * Time: 7:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public int trap(int[] A) {
        if (A.length < 3)
            return 0;
        Stack<Integer> stack = new Stack<Integer> ();
        stack.push(0);
        int sum = 0;

        // 0,1,0,2,1,0,1,3,2,1,2,1
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i-1]) {
                stack.push(i);
            } else {
                int l = 0;
                while (!stack.isEmpty()) {
                    l = stack.peek();
                    if (A[i] >= A[l]) {
                        stack.pop();
                        sum += (A[l] - A[l+1]) * (i-l-1);
                        if (stack.isEmpty()) {
                            stack.push(i);
                            break;
                        }
                    } else {
                        sum += (A[i] - A[l+1]) * (i-l-1);
                        A[l+1] = A[i];
                        stack.push(i);
                        break;
                    }
                }

            }
        }
        return sum;
    }
}