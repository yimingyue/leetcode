package EvaluateReversePolishNotation;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 11/28/14
 * Time: 7:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class Solution2 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                int rightOperand = stack.pop();
                int leftOperand = stack.pop();
                stack.push(leftOperand + rightOperand);
            } else if (token.equals("-")) {
                int rightOperand = stack.pop();
                int leftOperand = stack.pop();
                stack.push(leftOperand - rightOperand);
            } else if (token.equals("*")) {
                int rightOperand = stack.pop();
                int leftOperand = stack.pop();
                stack.push(leftOperand * rightOperand);
            } else if (token.equals("/")) {
                int rightOperand = stack.pop();
                int leftOperand = stack.pop();
                stack.push(leftOperand / rightOperand);
            } else {
                int value = Integer.parseInt(token);
                stack.push(value);
            }
        }
        return stack.pop();
    }
}
