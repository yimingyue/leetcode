package leetcode.LongestAbsoluteFilePath;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by ymyue on 9/18/16.
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Solution {
    public int lengthLongestPath(String input) {
        Deque<Integer> stack = new ArrayDeque<>();
        String[] lines = input.split("\n");
        int maxLength = 0;
        for (String line : lines) {
            int tabs = 0;
            while (tabs < line.length() && line.charAt(tabs) == '\t')
                tabs++;
            while (stack.size() > tabs)
                stack.pop();
            int length = (stack.isEmpty() ? 0 : stack.peek()) + line.length() - tabs + 1;
            if (line.indexOf('.') == -1) {
                stack.push(length);
            } else {
                maxLength = Math.max(maxLength, length-1);
            }
        }
        return maxLength;
    }
}
