package BinaryTreeMaxmumPath;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 2/21/14
 * Time: 6:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String [] args) {
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(4);
//        root.right = new TreeNode(8);
//        root.left.left = new TreeNode(11);
//        root.left.left.left = new TreeNode(7);
//        root.left.left.right = new TreeNode(2);
//        root.right.left = new TreeNode(13);
//        root.right.right = new TreeNode(4);
//        root.right.right.right = new TreeNode(1);
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        Solution s = new Solution();
        System.out.println(s.maxPathSum(root));
    }
}
