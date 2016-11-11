package leetcode.ExpressionAddOperators;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymyue on 10/23/16.
 */
public class Solution2 {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        helper(result, "", 0, 1, 1, 0, num, 0, target);
        return result;
    }

    private void helper(List<String> result, String str, int A, int sign, int B, int C, String num, int i, int target) {
        if (i == num.length()) {
            if (A + sign * B * C == target)
                result.add(str);
            return;
        }

        if (i == 0 || (C != 0 && (Integer.MAX_VALUE / C > 10 || Integer.MAX_VALUE % 10 >= num.charAt(i) - '0')))
            helper(result, str + num.charAt(i), A, sign, B, C * 10 + num.charAt(i) - '0', num, i+1, target);
        if (i > 0) {
            helper(result, str + '+' + num.charAt(i), A + sign * B * C, 1, 1, num.charAt(i) - '0', num, i+1, target);
            helper(result, str + '-' + num.charAt(i), A + sign * B * C, -1, 1, num.charAt(i) - '0', num, i+1, target);
            helper(result, str + '*' + num.charAt(i), A, sign, B * C, num.charAt(i) - '0', num, i+1, target);
        }
    }
}
