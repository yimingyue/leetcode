package leetcode.ValidNumber;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/30/14
 * Time: 8:17 AM
 * To change this template use File | Settings | File Templates.
 */
public class LeetcodeSolution {
    public boolean isNumber(String s) {
        int i = 0, n = s.length();
        while (i < n && Character.isWhitespace(s.charAt(i))) i++;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
        boolean isNumeric = false;
        while (i < n && Character.isDigit(s.charAt(i))) {
            i++;
            isNumeric = true;
        }
        if (i < n && s.charAt(i) == '.') {
            i++;
            while (i < n && Character.isDigit(s.charAt(i))) {
                i++;
                isNumeric = true;
            }
        }
        if (isNumeric && i < n && s.charAt(i) == 'e') {
            i++;
            isNumeric = false;
            if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
            while (i < n && Character.isDigit(s.charAt(i))) {
                i++;
                isNumeric = true;
            }
        }
        while (i < n && Character.isWhitespace(s.charAt(i))) i++;
        return isNumeric && i == n;
    }
}
