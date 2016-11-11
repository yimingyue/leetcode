package leetcode.RemoveKDigits;

/**
 * Created by ymyue on 9/22/16.
 * Time complexity: O(n)
 * Space complexity: O(n-k)
 */
public class Solution2 {
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < num.length() && k > 0) {
            if (sb.length() == 0) {
                sb.append(num.charAt(i));
                i++;
            } else {
                if (sb.charAt(sb.length()-1) <= num.charAt(i)) {
                    sb.append(num.charAt(i));
                    i++;
                } else {
                    sb.deleteCharAt(sb.length()-1);
                    k--;
                }
            }
        }
        while (i < num.length())
            sb.append(num.charAt(i++));
        while (k-- > 0)
            sb.deleteCharAt(sb.length()-1);
        i = 0;
        while (i < sb.length() && sb.charAt(i) == '0')
            i++;
        return i == sb.length() ? "0" : sb.substring(i);
    }
}
