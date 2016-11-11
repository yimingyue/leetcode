package leetcode.VerifyPreorderSerializationofaBinaryTree;

/**
 * Created by ymyue on 7/27/16.
 * Time complexity: O(n)
 * Space complexity: O(logN)
 */
public class SolutionRecursive {
    public boolean isValidSerialization(String preorder) {
        String[] strs = preorder.split(",");
        return helper(strs, 0) == strs.length;
    }

    private int helper(String[] strs, int i) {
        if (i < 0 || i == strs.length)
            return -1;
        if (strs[i].equals("#"))
            return i+1;
        return helper(strs, helper(strs, i+1));
    }
}
