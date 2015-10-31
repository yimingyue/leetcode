package leetcode.PopulatingNextRightPointersinEachNodeII;

import org.junit.Test;

/**
 * Created by ymyue on 10/10/15.
 */
public class TestPopulatingNextRightPointersinEachNodeII {
    @Test
    public void test0() {
        Solution solution = new Solution();
        TreeLinkNode root = new TreeLinkNode(1);
        TreeLinkNode left = new TreeLinkNode(2);
        root.left = left;
        solution.connect(root);
    }
}
