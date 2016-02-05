package leetcode.ValidNumber;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 4/18/14
 * Time: 2:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.isEmpty())
            return false;
        int i = 0;
        char ch = s.charAt(i);
        if (ch != '+' && ch != '-' && (ch < '0' || ch > '9') && ch != '.')
            return false;
        if (ch == '+' || ch == '-') {
            i++;
            ch = s.charAt(i);
        }
        boolean isNumber = false;
        while (ch >= '0' && ch <= '9') {
            i++;
            if (i == s.length())
                return true;
            ch = s.charAt(i);
            isNumber = true;
        }
        if (ch != '.' && ch != 'e')
            return false;
        if (ch == '.') {
            i++;
            if (i == s.length()) {
                if (isNumber)
                    return true;
                return false;
            }
            ch = s.charAt(i);
            if ((ch < '0' || ch > '9') && ch != 'e')
                return false;
            while (ch >= '0' && ch <= '9') {
                i++;
                if (i == s.length())
                    return true;
                ch = s.charAt(i);
            }
        }
        if (ch != 'e')
            return false;
        if (i == s.length()-1)
            return false;
        i++;
        ch = s.charAt(i);
        if (ch != '-' && (ch < '0' || ch > '9'))
            return false;
        if (ch == '-' && i == s.length()-1)
            return false;
        i++;
        while (i < s.length()) {
            ch = s.charAt(i);
            if (ch < '0' || ch > '9')
                return false;
            i++;
        }
        return true;
    }
}
