package leetcode.RemoveKDigits;

/**
 * Created by ymyue on 9/17/16.
 */
public class Solution {
    public String removeKdigits(String num, int k) {
        while (k-- > 0)
            num = removeDigit(num);
        if (num.isEmpty())
            return "0";
        int i = 0;
        while (i < num.length()-1 && num.charAt(i) == '0')
            i++;
        return num.substring(i);
    }

    private String removeDigit(String num) {
        if (num.isEmpty())
            return num;
        for (int i = 0; i < num.length()-1; i++) {
            if (num.charAt(i) > num.charAt(i+1))
                return num.substring(0, i) + num.substring(i+1);
        }
        return num.substring(0, num.length()-1);
    }
}
