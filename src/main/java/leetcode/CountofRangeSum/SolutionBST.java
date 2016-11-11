package leetcode.CountofRangeSum;

/**
 * Created by ymyue on 7/14/16.
 */
public class SolutionBST {
    class Node {
        long val;
        int count;
        Node left;
        Node right;
        Node(long val) {
            this.val = val;
            this.count = 1;
        }
    }

    private Node insert(Node root, long val) {
        if (root == null)
            return new Node(val);
        if (root.val == val)
            root.count++;
        else if (root.val < val)
            root.right = insert(root.right, val);
        else
            root.left = insert(root.left, val);
        return root;
    }

    private int search(Node root, long lower, long upper) {
        if (root == null)
            return 0;
        if (root.val >= lower && root.val <= upper)
            return root.count + search(root.left, lower, upper) + search(root.right, lower, upper);
        else if (root.val < lower)
            return search(root.right, lower, upper);
        else
            return search(root.left, lower, upper);
    }


    public int countRangeSum(int[] nums, int lower, int upper) {
        long sum = 0;
        int count = 0;
        Node root = insert(null, 0);
        for (int num : nums) {
            sum += num;
            count += search(root, sum-upper, sum-lower);
            insert(root, sum);
        }
        return count;
    }

    private Node insert(Node root, long val, int lower, int upper, boolean b, int[] count, int i) {
        if (b) {
            if (root == null)
                return new Node(val);
            if (val - root.val >= lower && val - root.val <= upper)
                count[i] += root.count;
            if (root.val == val) {
                root.count++;
                insert(root.left, val, lower, upper, false, count, i);
                insert(root.right, val, lower, upper, false, count, i);
            } else if (root.val < val) {
                insert(root.left, val, lower, upper, false, count, i);
                insert(root.right, val, lower, upper, true, count, i);
            } else {
                insert(root.left, val, lower, upper, true, count, i);
                insert(root.right, val, lower, upper, false, count, i);
            }
        } else {
            if (root == null)
                return root;
            if (val - root.val >= lower && val - root.val <= upper) {
                count[i] += root.count;
                insert(root.left, val, lower, upper, false, count, i);
                insert(root.right, val, lower, upper, false, count, i);
            } else if (val - root.val < lower) {
                insert(root.left, val, lower, upper, false, count, i);
            } else
                insert(root.right, val, lower, upper, false, count, i);
        }
        return root;
    }
}
