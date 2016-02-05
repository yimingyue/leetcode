package leetcode.ReverseWordsinaString;

/**
 * Created by ymyue on 1/16/16.
 */
public class Solution2 {
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        if (strs.length == 0)
            return "";
        StringBuilder sb = new StringBuilder();
        sb.append(strs[strs.length-1]);
        for (int i = strs.length-2; i >= 0; i--) {
            sb.append(' ');
            sb.append(strs[i]);
        }
        return sb.toString();
    }
}
