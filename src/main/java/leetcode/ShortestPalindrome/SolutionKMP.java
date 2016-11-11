package leetcode.ShortestPalindrome;

/**
 * Created by ymyue on 7/30/16.
 */
public class SolutionKMP {
    public String shortestPalindrome(String s) {
        if (s.length() < 2)
            return s;
        int[] t = preprocessing(s.toCharArray());
        int j = 0;
        int max = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            while (j >= 0 && s.charAt(i) != s.charAt(j))
                j = t[j];
            max = Math.max(max, j);
            j++;
        }
        return new StringBuilder(s.substring(j)).reverse() + s;
    }

    private int[] preprocessing(char[] str) {
        int[] t = new int[str.length+1];
        int i = 0;
        int j = -1;
        t[i] = j;
        while (i < str.length) {
            while (j >= 0 && str[i] != str[j])
                j = t[j];
            i++;
            j++;
            t[i] = j;
        }
        return t;
    }
}
