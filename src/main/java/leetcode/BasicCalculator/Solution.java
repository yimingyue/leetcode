package leetcode.BasicCalculator;

import java.util.Stack;

/**
 * Created by ymyue on 6/9/15.
 */
public class Solution {
    public int calculate(String s) {
        Stack<Long> operands = new Stack<> ();
        Stack<Character> operators = new Stack<> ();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                long operand = 0;
                while (Character.isDigit(ch)) {
                    operand = 10 * operand + Character.getNumericValue(ch);
                    i++;
                    if (i == s.length()) break;
                    ch = s.charAt(i);
                }
                operands.push(operand);
            } else if (ch == '+' || ch == '-') {
                operators.push(ch);
            } else if (ch == '(') {
                int count = 1;
                int j = i+1;
                while (j < s.length()) {
                    if (s.charAt(j) == '(')
                        count++;
                    else if (s.charAt(j) == ')') {
                        count--;
                        if (count == 0) {
                            operands.push((long)calculate(s.substring(i+1, j)));
                            i = j+1;
                            break;
                        }
                    }
                    j++;
                }
            }
        }
        long val = operands.pop();
        while (!operators.isEmpty()) {
            char ch = operators.pop();
            long leftOp = operands.pop();
            if (ch == '+')
                val = leftOp + val;
            else if (ch == '-')
                val = leftOp - val;
        }
        return (int)val;
    }
}
