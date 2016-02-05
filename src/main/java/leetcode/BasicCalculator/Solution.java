package leetcode.BasicCalculator;

import java.util.Stack;

/**
 * Created by ymyue on 6/9/15.
 */
public class Solution {
    public int calculate(String s) {
        Stack<Integer> operands = new Stack<> ();
        Stack<Character> operators = new Stack<> ();
        int cur = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '+' || ch == '-' || ch == '(') {
                operators.push(ch);
            } else if (Character.isDigit(ch)) {
                int num = ch - '0';
                int j = i+1;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    num *= 10;
                    num += s.charAt(j) - '0';
                    j++;
                }
                if (operators.isEmpty() || operators.peek() == '(') {
                    operands.push(cur);
                    cur = num;
                } else {
                    if (operators.pop() == '+') {
                        cur += num;
                    } else {
                        cur -= num;
                    }
                }
                i = j-1;
            } else if (ch == ')') {
                operators.pop();
                if (!operators.isEmpty()){
                    cur = operands.pop() + (operators.pop() == '+' ? cur : -cur);
                }
            }
        }

        return cur;
    }
}
