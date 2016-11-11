package leetcode.ValidParentheses;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by ymyue on 7/8/16.
 */
public class Solution {
    public boolean isValid(String s) {
        Deque<Character> queue = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                queue.offer(c);
            } else if (c == ')') {
                if (queue.isEmpty() || queue.pollLast() != '(')
                    return false;
            } else if (c == ']') {
                if (queue.isEmpty() || queue.pollLast() != '[')
                    return false;
            } else if (c == '}') {
                if (queue.isEmpty() || queue.pollLast() != '{')
                    return false;
            }
        }
        return queue.isEmpty();
    }
}
