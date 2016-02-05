package leetcode.BasicCalculatorII;

import java.util.Stack;

/**
 * Created by ymyue on 1/14/16.

 Implement a basic calculator to evaluate a simple expression string.

 The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

 You may assume that the given expression is always valid.

 Some examples:
 "3+2*2" = 7
 " 3/2 " = 1
 " 3+5 / 2 " = 5
 Note: Do not use the eval built-in library function.
 */

public class Solution {
    public int calculate(String s) {
        int result = 0;
        int number = 0;
        char ch = ' ';
        char op = ' ';
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                number = number * 10 + ch - '0';
            } else if  (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                if ((ch == '*' || ch == '/') && (op == '+' || op == '-')) {
                    stack.push(result);
                    stack.push(op == '+' ? 1 : -1);
                    result = number;
                } else { // 1 + 2 * 3 / 4 - 5
                    result = evaluate(result, op, number);
                    if ((ch == '+' || ch == '-') && !stack.isEmpty()) {
                        result *= stack.pop();
                        result += stack.pop();
                    }
                }
                number = 0;
                op = ch;
            }
        }
        result = evaluate(result, op, number);
        if (!stack.isEmpty()) {
            result *= stack.pop();
            result += stack.pop();
        }
        return result;
    }

    private int evaluate(int result, char op, int number) {
        switch (op) {
            case '+' : return result + number;
            case '-' : return result - number;
            case '*' : return result * number;
            case '/' : return result / number;
            case ' ' : return number;
            default: return result;
        }
    }
}
