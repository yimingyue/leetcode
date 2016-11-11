package leetcode.VerifyPreorderSerializationofaBinaryTree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by ymyue on 7/16/16.
 */
public class Solution {
    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0)
            return false;
        if (preorder.equals("#"))
            return true;
        Deque<Integer> counts = new ArrayDeque<>();
        String[] nodes = preorder.split(",");
        if (nodes[0].equals("#"))
            return false;
        counts.push(2);
        int i = 1;
        while (i < nodes.length && !counts.isEmpty()) {
            if (nodes[i].equals("#")) {
                while (!counts.isEmpty()) {
                    if (counts.peek() == 1) {
                        counts.pop();
                    } else {
                        counts.push(counts.pop()-1);
                        break;
                    }
                }
            } else {
                counts.push(2);
            }
            i++;
        }
        return counts.isEmpty() && i == nodes.length;
    }
}
