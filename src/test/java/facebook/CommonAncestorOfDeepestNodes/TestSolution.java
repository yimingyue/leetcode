package facebook.CommonAncestorOfDeepestNodes;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 2/2/16.
 */
public class TestSolution {
    @Test
    public void test0() {
        TreeNode node0 = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);

        node0.children.add(node1);
        node0.children.add(node2);
        node0.children.add(node3);
        node2.children.add(node4);
        node4.children.add(node5);
        node3.children.add(node6);
        node3.children.add(node7);
        node4.children.add(node8);
        assertEquals(4, new Solution().getCommonAncestor(node0).val);
    }
}
