package leetcode.BinaryTreeLongestConsecutiveSequence;

import ds.TreeNode;
import org.junit.Assert;
import org.junit.Test;
import utils.BinaryTreeSerialization;

/**
 * Created by ymyue on 10/19/16.
 */
public class TestSolution {
    Solution solution = new Solution();

    @Test
    public void test0() {
        TreeNode root = BinaryTreeSerialization.serializeTreeNode("1,#,3,2,4,#,#,#,5");
        Assert.assertEquals(3, solution.longestConsecutive(root));
    }
}
