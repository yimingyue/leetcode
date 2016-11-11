package google.IsSubTree;

import ds.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ymyue on 10/16/16.
 */
public class TestSolution {
    Solution solution = new Solution();

    @Test
    public void test0() {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);

        TreeNode root2 = new TreeNode(2);
        root2.left = root1;
        Assert.assertTrue(solution.isSubStree(root2, root1));
    }

    @Test
    public void test1() {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(4);
        root2.right.right = new TreeNode(1);
        Assert.assertTrue(solution.isSubStree(root2, root1));
    }
}
