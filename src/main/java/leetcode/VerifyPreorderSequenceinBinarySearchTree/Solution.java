package leetcode.VerifyPreorderSequenceinBinarySearchTree;

import java.util.Stack;

/**
 * Created by ymyue on 1/30/16.
 */
public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        if (preorder.length == 0)
            return true;
        Stack<Integer> stack = new Stack<> ();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < preorder.length; i++) {
            if (preorder[i] < max)
                return false;
            while (!stack.isEmpty() && preorder[i] > stack.peek())
                max = Math.max(max, stack.pop());
            stack.push(preorder[i]);
        }
        return true;
    }
}
