package leetcode.ValidParentheses;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by ymyue on 10/19/16.
 */
public class Solution2 {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(')
                    return false;
            } else if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[')
                    return false;
            } else if (c == '}') {
                if (stack.isEmpty() || stack.pop() != '{')
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
