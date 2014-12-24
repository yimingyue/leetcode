package LongestValidParenthesis;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 4/7/14
 * Time: 10:55 AM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<Character> ();
        int lastCount = 0;
        int count = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (i == 0 || s.charAt(i-1) == ')') {
                    lastCount = count;
                    count = 0;
                }
                stack.push('(');
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    count = 0;
                    continue;
                }
                char c = stack.pop().charValue();
                if (c == '(') {
                    count+=2;
                    if (stack.isEmpty() || stack.peek() == '(')
                        count += lastCount;
                    if (count > max)
                        max = count;
                } else
                    count = 0;
            }
        }
        return max;
    }
}
