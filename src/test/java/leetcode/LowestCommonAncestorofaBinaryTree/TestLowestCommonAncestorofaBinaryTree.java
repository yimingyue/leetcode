package leetcode.LowestCommonAncestorofaBinaryTree;

import ds.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 11/4/15.
 */
public class TestLowestCommonAncestorofaBinaryTree {
    @Test
    public void test0 () {
        TreeNode t = new TreeNode(-1);
        TreeNode t1 = new TreeNode(0);
        TreeNode t2 = new TreeNode(3);
        t.left = t1;
        t.right = t2;
        TreeNode t3 = new TreeNode(-2);
        t1.left = t3;
        TreeNode t4 = new TreeNode(4);
        t1.right = t4;
        TreeNode t5 = new TreeNode(8);
        t3.left = t5;
        assertEquals(t1, new Solution().lowestCommonAncestor(t, t5, t4));
    }
}
