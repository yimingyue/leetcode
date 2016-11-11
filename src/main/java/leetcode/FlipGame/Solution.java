package leetcode.FlipGame;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymyue on 7/18/16.
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<>();
        char[] str = s.toCharArray();
        for (int i = 0; i+1 < str.length; i++) {
            if (str[i] == '+' && str[i+1] == '+') {
                str[i] = '-'; str[i+1] = '-';
                result.add(String.valueOf(str));
                str[i] = '+'; str[i+1] = '+';
            }
        }
        return result;
    }
}
