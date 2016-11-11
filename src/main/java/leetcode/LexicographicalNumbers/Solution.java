package leetcode.LexicographicalNumbers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymyue on 9/18/16.
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Solution {
    public List<Integer> lexicalOrder(int n) {
        int val = 1;
        List<Integer> result = new ArrayList<> ();
        result.add(val);
        while (result.size() < n) {
            val = nextLexical(n, val);
            result.add(val);
        }
        return result;
    }

    private int nextLexical(int n, int val) {
        if (val * 10 <= n)
            return val * 10;
        while (val % 10 == 9 || val == n)
            val /= 10;
        return val + 1;
    }
}
