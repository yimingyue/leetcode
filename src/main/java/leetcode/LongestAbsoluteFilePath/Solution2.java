package leetcode.LongestAbsoluteFilePath;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by ymyue on 10/18/16.
 */
public class Solution2 {
    public int lengthLongestPath(String input) {
        if (input.isEmpty())
            return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        int j = 0;
        int length = 0;
        int maxLength = 0;
        boolean isFile = false;
        char ch;
        while (i <= input.length()) {
            if (i == input.length() || (ch = input.charAt(i)) == '\n') {
                int len = stack.isEmpty() ? i - j : i - j + 1;
                length += len;
                stack.push(len);
                i++;
                if (isFile)
                    maxLength = Math.max(maxLength, length);
                isFile = false;
                int tabs = 0;
                while (i < input.length() && input.charAt(i) == '\t') {
                    tabs++;
                    i++;
                }
                while (stack.size() > tabs) {
                    length -= stack.poll();
                }
                j = i;
            } else if (ch == '/') {
                int len = stack.isEmpty() ? i-j : i-j+1;
                length += len;
                stack.push(len);
                i++;
                j = i;
            } else if (ch == '.') {
                isFile = true;
                i++;
            } else
                i++;
        }
        return maxLength;
    }
}
