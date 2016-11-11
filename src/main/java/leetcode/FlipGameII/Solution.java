package leetcode.FlipGameII;

/**
 * Created by ymyue on 7/16/16.
 * BackTracking
 */
public class Solution {
    public boolean canWin(String s) {
        return canWin(s.toCharArray());
    }

    private boolean canWin(char[] str) {
        for (int i = 0; i < str.length-1; i++) {
            boolean win = false;
            if (str[i] == '+' && str[i+1] == '+') {
                str[i] = '-';
                str[i+1] = '-';
                if (!canWin(str))
                    win = true;
                str[i] = '+';
                str[i+1] = '+';
                if (win)
                    return win;
            }
        }
        return false;
    }
}
