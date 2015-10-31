package leetcode.PopulatingNextRightPointersinEachNodeII;

/**
 * Created by ymyue on 10/10/15.
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;
        connect(root.left);
        connect(root.right);
        connect(root.left, root.right);
    }

    private void connect(TreeLinkNode left, TreeLinkNode right) {
        int i = 0;
        while (true) {
            TreeLinkNode nextLeft = searchLeft(left, i);
            TreeLinkNode nextRight = searchRight(right, i);
            if (nextLeft == null)
                break;
            else {
                nextLeft.next = nextRight;
                i++;
            }
        }
    }

    private TreeLinkNode searchLeft(TreeLinkNode root, int i) {
        if (i == 0)
            return root;
        if (root == null)
            return root;
        TreeLinkNode right = searchLeft(root.right, i-1);
        if (right != null)
            return right;
        return searchLeft(root.left, i-1);
    }

    private TreeLinkNode searchRight(TreeLinkNode root, int i) {
        if (i == 0)
            return root;
        if (root == null)
            return root;
        TreeLinkNode left = searchRight(root.left, i-1);
        if (left != null)
            return left;
        return searchRight(root.right, i-1);
    }
}
