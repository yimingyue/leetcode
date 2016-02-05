package leetcode.DecodeWays;

/**
 * Created by ymyue on 1/1/16.
 */
public class Solution {
    public int numDecodings(String s) {
        if (s.isEmpty() || s.charAt(0) == '0')
            return 0;
        int pre = 1;
        int cur = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0')
                cur = 0;
            if (s.charAt(i-1) == '1' || s.charAt(i-1) == '2' && s.charAt(i) <= '6') {
                cur = pre + cur;
                pre = cur - pre;
            } else {
                pre = cur;
            }
        }
        return cur;
    }
}
