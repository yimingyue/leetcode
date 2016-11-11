package leetcode.ShortestPalindrome;

/**
 * Created by ymyue on 7/30/16.
 */
public class SolutionKMPImprove {
    public String shortestPalindrome(String s) {
        if (s.length() < 2)
            return s;
        String str = s + "#" + new StringBuilder(s).reverse();
        int[] t = preprocessing(str);
        return new StringBuilder(s.substring(t[t.length-1])).reverse() + s;
    }

    private int[] preprocessing(String str) {
        return preprocessing(str.toCharArray());
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
