package leetcode.EvaluateReversePolishNotation;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 5/3/14
 * Time: 8:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    private enum Operator {
        PLUS ("+"),
        MINUS ("-"),
        MULTIPLY ("*"),
        DIVIDE ("/");
        Operator(String s) {
            this.operator = s;
        }
        private String operator;
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        if (tokens.length == 0)
            return 0;
        Map<String, Operator> map = new HashMap<String, Operator>();
        map.put("+", Operator.PLUS);
        map.put("-", Operator.MINUS);
        map.put("*", Operator.MULTIPLY);
        map.put("/", Operator.DIVIDE);
        while (i < tokens.length) {
            if (map.keySet().contains(tokens[i])) {
                Operator o = map.get(tokens[i]);
                int rightOperand = stack.pop();
                int leftOperand = stack.pop();
                int resultInt = 0;
                switch (o) {
                    case PLUS : resultInt = leftOperand + rightOperand;
                        break;
                    case MINUS: resultInt = leftOperand - rightOperand;
                        break;
                    case MULTIPLY: resultInt = leftOperand * rightOperand;
                        break;
                    case DIVIDE: resultInt = leftOperand / rightOperand;
                        break;
                }
                stack.push(resultInt);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
            i++;
        }
        return stack.pop();
    }
}

