package leetcode.ClosestBinarySearchTreeValueII;

import ds.TreeNode;
import org.junit.Assert;
import org.junit.Test;
import utils.BinaryTreeSerialization;

/**
 * Created by ymyue on 10/23/16.
 */
public class TestSolution {
    Solution2 solution = new Solution2();

    @Test
    public void test0() {
        TreeNode root = BinaryTreeSerialization.serializeTreeNode("4,2,8,#,#,7,9,#,#,#,#");

        Assert.assertArrayEquals(new Integer[] {4}, solution.closestKValues(root, 5.0, 1).toArray());
    }
}
