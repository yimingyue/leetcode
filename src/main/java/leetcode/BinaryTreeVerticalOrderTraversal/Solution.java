package leetcode.BinaryTreeVerticalOrderTraversal;

import ds.TreeNode;

import java.util.*;

/**
 * Created by ymyue on 6/13/16.
 * Time complexity: O(n)
 * Space complexity: O(n) + O(n) + O(n) = O(n)
 */
public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        Map<TreeNode, Integer> index = new HashMap<>();
        Map<Integer, List<Integer>> map = new HashMap<> ();
        Deque<TreeNode> queue = new ArrayDeque<> ();
        queue.offer(root);
        index.put(root, 0);
        int left = 0;
        int right = 0;
        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                int idx = index.get(node);
                index.remove(node);
                map.putIfAbsent(idx, new ArrayList<Integer> ());
                map.get(idx).add(node.val);
                if (node.left != null) {
                    left = Math.min(left, idx-1);
                    index.put(node.left, idx-1);
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    right = Math.max(right, idx+1);
                    index.put(node.right, idx+1);
                    queue.offer(node.right);
                }
            }
        }
        for (int i = left; i <= right; i++)
            result.add(map.get(i));
        return result;
    }
}
