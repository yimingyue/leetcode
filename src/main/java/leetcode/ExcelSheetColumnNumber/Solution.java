package leetcode.ExcelSheetColumnNumber;

/**
 * Created by ymyue on 10/30/15.
 */
public class Solution {
    public int titleToNumber(String s) {
        if (s == null || s.isEmpty())
            return 0;
        int val = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            val *= 26;
            val += (int)(ch - 'A' + 1);
        }
        return val;
    }
}
