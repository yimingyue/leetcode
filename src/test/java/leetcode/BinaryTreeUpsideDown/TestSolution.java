package leetcode.BinaryTreeUpsideDown;

import ds.TreeNode;
import org.junit.Test;

/**
 * Created by ymyue on 11/22/15.
 */
public class TestSolution {
    @Test
    public void test0() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        t1.left = t2;
        TreeNode t = new Solution().upsideDownBinaryTree(t1);
    }
}
