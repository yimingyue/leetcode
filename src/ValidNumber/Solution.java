package ValidNumber;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 4/18/14
 * Time: 2:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public boolean isNumber(String s) {
        boolean decimal = false;
        boolean exp = false;
        s = s.trim();
        if (s.isEmpty())
            return false;

        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (i == 0) {
                if (c == '-' || c == '+') {
                    if (i == s.length()-1)
                        return false;
                    i++;
                    char ch = s.charAt(i);
                    if (ch == '.') {
                        decimal = true;
                        i++;
                        if (i == s.length())
                            return false;
                        ch = s.charAt(i);
                        if (ch - '0' < 0 || ch - '0' > 9)
                            return false;
                    }
                    else if (ch - '0' < 0 || ch - '0' > 9)
                        return false;
                } else if (c == '.') {
                    decimal = true;
                    i++;
                    if (i == s.length())
                        return false;
                    c = s.charAt(i);
                    if (c - '0' < 0 || c - '0' > 9)
                        return false;
                }
                else if (c - '0' < 0 || c - '0' > 9)
                    return false;
            } else {
                if (c == '.') {
                    if (decimal)
                        return false;
                    else {
                        decimal = true;
                        i++;
                        if (i == s.length())
                            return true;
                        c = s.charAt(i);
                        if (c - '0' < 0 || c - '0' > 9)
                            return false;
                    }
                } else if (c == 'e') {
                    if (exp)
                        return false;
                    else {
                        exp = true;
                        i++;
                        if (i == s.length())
                            return false;
                        char ch = s.charAt(i);
                        decimal = false;
                        if (ch == '-') {
                            if (i == s.length()-1)
                                return false;
                        }
                        else if (ch - '0' < 0 || ch - '0' > 9)
                            return false;
                    }
                } else if (c - '0' < 0 || c - '0' > 9)
                    return false;
            }
            i++;
        }
        return true;
    }
}
