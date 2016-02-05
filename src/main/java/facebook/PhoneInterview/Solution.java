package facebook.PhoneInterview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by ymyue on 2/4/16.
 * <p>
 * Welcome to Facebook!
 * <p>
 * This is just a simple shared plaintext pad, with no execution capabilities.
 * <p>
 * When you know what language you'd like to use for your interview,
 * simply choose it from the dropdown in the top bar.
 * <p>
 * Enjoy your interview!
 * <p>
 * <p>
 * // Thank you for being my interviewer!
 * // Yiming Yue - Feb 4, 2016
 * <p>
 * A: [1,3,5,7,_,_,_,8]
 * B: [2,4,6,8]
 * <p>
 * => A: [1,2,3,4,5,6,7,8]
 */
public class Solution {
    public void mergeTwoSortedArray(int[] A, int m, int[] B, int n) {
        int i = m - 1;
        int j = n - 1;
        while (j >= 0) {
            if (i < 0) {
                A[j] = B[j];
                j--;
            } else if (A[i] < B[j]) {
                A[i + j + 1] = B[j];
                j--;
            } else {
                A[i + j + 1] = A[i];
                i--;
            }
        }
    }

    /*
            Tree example:
            8
            6   9
            5
            7
            => 5 6 7 8 9
    */
    class Node {
        Node left;
        Node right;
        int val;
    }

    ;

    public void verticalOrder(Node root) {
        if (root == null)
            return;
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        LinkedList<Node> queue = new LinkedList<>();
        LinkedList<Integer> col = new LinkedList<>();

        queue.add(root);
        col.add(0);
        int left = 0;
        int right = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int column = col.poll();
            if (!map.containsKey(column))
                map.put(column, new ArrayList<Integer>());
            map.get(column).add(node.val);
            if (node.left != null) {
                queue.add(node.left);
                col.add(column - 1);
                left = Math.min(left, column - 1);
            }
            if (node.right != null) {
                queue.add(node.right);
                col.add(column + 1);
                right = Math.max(right, column + 1);
            }
        }

        for (int i = left; i <= right; i++) {
            for (int val : map.get(i))
                System.out.println(val);
        }
    }
}