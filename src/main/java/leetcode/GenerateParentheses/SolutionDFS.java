package leetcode.GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymyue on 7/10/16.
 * Time complexity: O(2^N)
 */
public class SolutionDFS {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, "", n, 0);
        return res;
    }

    private void helper(List<String> res, String parenthesis, int n, int k) {
        if (n == k) {
            while (parenthesis.length() < 2*n)
                parenthesis += ")";
            res.add(parenthesis);
            return;
        }
        helper(res, parenthesis + "(", n, k+1);
        if (parenthesis.length() < 2*k)
            helper(res, parenthesis + ")", n, k);
    }
}
