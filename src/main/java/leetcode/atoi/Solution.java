package leetcode.atoi;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 4/1/14
 * Time: 10:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public int atoi(String str) {
        if (str == null)
            return 0;
        if (str.length() == 0)
            return 0;
        int val = 0;
        boolean positive = true;
        int i = 0;
        while (i < str.length()) {
            if (str.charAt(i) == '-') {
                positive = false;
                i++;
                break;
            } else if (str.charAt(i) == '+') {
                positive = true;
                i++;
                break;
            } else if (str.charAt(i) == ' ' || str.charAt(i) == '\t') {
                i++;
            } else if (str.charAt(i) <= '9' || str.charAt(i) >= '0') {
                break;
            } else
                return getVal(val, positive);
        }

        while (i < str.length()) {
            char c = str.charAt(i);
            if (c > '9' || c < '0')
                return getVal(val, positive);
            int digit = c - '0';
            if (positive) {
                if (val > Integer.MAX_VALUE/10 || (val == Integer.MAX_VALUE/10 && digit > Integer.MAX_VALUE%10))
                    return Integer.MAX_VALUE;
            } else {
                if (val > (Integer.MAX_VALUE)/10 || (val == (Integer.MAX_VALUE)/10 && digit > (Integer.MAX_VALUE)%10+1))
                    return Integer.MIN_VALUE;
            }
            val = val*10 + digit;
            i++;
        }
        return getVal(val, positive);
    }
    private int getVal(int val, boolean positive) {
        if (positive)
            return val;
        return -val;
    }
}
