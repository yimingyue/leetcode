package leetcode.PostoderTraversal;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 2/8/14
 * Time: 10:04 AM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String [] argv) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left = left;
        root.right = null;
        left.left = null;
        left.right = null;
        Solution s = new Solution();
        s.postorderTraversal(root);
    }
}
