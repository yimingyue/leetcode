package leetcode.ContainsDuplicateIII;

/**
 * Created by ymyue on 7/1/16.
 * Time complexity: O(nlogK)
 * Space complexity: O(k)
 */
public class Solution2 {
    class BST {
        int val;
        BST left;
        BST right;
        public BST(int x) {
            this.val = x;
        }
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0)
            return false;
        if (k < 1)
            return false;
        int i = 1;
        int j = 0;
        BST root = new BST(nums[0]);
        while (i <= k && i < nums.length) {
            if (!addToBST(root, nums[i], t))
                return true;
            i++;
        }
        while (i < nums.length) {
            root = removeFromBST(root, nums[j++]);
            if (!addToBST(root, nums[i], t))
                return true;
            i++;
        }
        return false;
    }

    private boolean addToBST(BST root, int val, int t) {
        if (Math.abs((long)root.val - val) <= t)
            return false;
        if (root.val < val) {
            if (root.right == null) {
                root.right = new BST(val);
                return true;
            } else
                return addToBST(root.right, val, t);
        } else {
            if (root.left == null) {
                root.left = new BST(val);
                return true;
            } else {
                return addToBST(root.left, val, t);
            }
        }
    }

    private BST removeFromBST(BST root, int val) {
        if (root.val == val) {
            if (root.right == null)
                return root.left;
            else if (root.right.left == null) {
                root.right.left = root.left;
                return root.right;
            } else {
                BST r = root.right;
                BST p = root.right.left;
                while (p.left != null) {
                    r = p;
                    p = p.left;
                }
                r.left = p.right;
                p.left = root.left;
                p.right = root.right;
                return p;
            }
        } else if (root.val < val) {
            root.right = removeFromBST(root.right, val);
            return root;
        } else {
            root.left = removeFromBST(root.left, val);
            return root;
        }
    }
}
