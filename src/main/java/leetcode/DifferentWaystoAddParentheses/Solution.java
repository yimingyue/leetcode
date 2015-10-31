package leetcode.DifferentWaystoAddParentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymyue on 8/3/15.
 */
public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> rList = new ArrayList<>();
        evaluate(rList, input);
        return rList;
    }

    private void evaluate(List<Integer> rList, String input) {
        if (input == null || input.isEmpty())
            return;
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < input.length() && Character.isDigit(input.charAt(i))) {
            sb.append(input.charAt(i++));
        }
        int leftOp = Integer.parseInt(sb.toString());

        if (i == input.length()) {
            rList.add(leftOp);
            return;
        }

        String pre = "";
        while (i != input.length()) {
            char op = input.charAt(i++);
            StringBuilder sb2 = new StringBuilder();
            while (i < input.length() && Character.isDigit(input.charAt(i))) {
                sb2.append(input.charAt(i++));
            }
            int rightOp = Integer.parseInt(sb2.toString());

            int r = 0;
            switch (op) {
                case '+' : r = leftOp + rightOp; break;
                case '-' : r = leftOp - rightOp; break;
                case '*' : r = leftOp * rightOp; break;
            }
            if (i == input.length()) {
                rList.add(r);
            } else {
                evaluate(rList, pre + String.valueOf(r) + input.substring(i));
            }
            pre = pre + String.valueOf(leftOp) + String.valueOf(op);
            leftOp = rightOp;
            i++;
        }
    }
}
