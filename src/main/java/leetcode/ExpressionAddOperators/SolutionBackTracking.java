package leetcode.ExpressionAddOperators;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymyue on 7/13/16.
 * Time complexity: O(4^n)
 * Space complexity: O(1)
 */
public class SolutionBackTracking {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        helper(res, num, 0, 0, 1, 1, 0, new StringBuilder(), target);
        return res;
    }

    private void helper(List<String> res, String num, int i, int pre, int op, int base, int cur, StringBuilder sb, int target) {
        if (i == num.length()) {
            if (pre + op * base * cur == target)
                res.add(sb.toString());
            return;
        }
        if (i == 0) {
            cur = num.charAt(0) - '0';
            sb.append(num.charAt(0));
            helper(res, num, i+1, pre, op, base, cur, sb, target);
            sb.setLength(0);
        } else {
            if (cur != 0 && (cur < Integer.MAX_VALUE/10 || (cur == Integer.MAX_VALUE/10 && num.charAt(i) - '0' <= Integer.MAX_VALUE%10))) {
                // append digit
                sb.append(num.charAt(i));
                helper(res, num, i+1, pre, op, base, cur * 10 + (num.charAt(i) - '0'), sb, target);
                sb.setLength(sb.length()-1);
            }

            sb.append("+");
            sb.append(num.charAt(i));
            helper(res, num, i+1, pre + op * base * cur, 1, 1, num.charAt(i) - '0', sb, target);
            sb.setLength(sb.length()-2);

            sb.append("-");
            sb.append(num.charAt(i));
            helper(res, num, i+1, pre + op * base * cur, -1, 1, num.charAt(i) - '0', sb, target);
            sb.setLength(sb.length()-2);

            sb.append("*");
            sb.append(num.charAt(i));
            helper(res, num, i+1, pre, op, base * cur, num.charAt(i) - '0', sb, target);
            sb.setLength(sb.length()-2);
        }
    }
}
