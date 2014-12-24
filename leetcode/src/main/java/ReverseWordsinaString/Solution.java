package ReverseWordsinaString;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 11/23/14
 * Time: 4:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int j = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                j = i;
            } else if (i == 0 || s.charAt(i-1) == ' ') {
                if (sb.length() != 0)
                    sb.append(' ');
                sb.append(s.substring(i, j));
            }
        }
        return sb.toString();
    }
}
