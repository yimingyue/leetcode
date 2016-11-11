package leetcode.BasicCalculator;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by ymyue on 8/1/16.
 */
public class SolutionNeat {
    public int calculate(String s) {
        int cur = 0;
        int prev = 0;
        int op = 1;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                cur *= 10;
                cur += ch - '0';
            } else if (ch == '+') {
                prev += op * cur;
                op = 1;
                cur = 0;
            } else if (ch == '-') {
                prev += op * cur;
                op = -1;
                cur = 0;
            } else if (ch == '(') {
                stack.push(prev);
                stack.push(op);
                prev = 0;
                op = 1;
                cur = 0;
            } else if (ch == ')') {
                cur = prev + op * cur;
                op = stack.pop();
                prev = stack.pop();
            }
        }
        return prev + op * cur;
    }
}
