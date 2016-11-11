package leetcode.LongestSubstringwithAtMostKDistinctCharacters;

/**
 * Created by ymyue on 10/19/16.
 */
public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int i = 0;
        int j = 0;
        int[] counts = new int[256];
        int cou = 0;
        int max = 0;

        while (i < s.length()) {
            char ch = s.charAt(i);
            if (counts[ch]++ == 0)
                cou++;
            while (cou > k) {
                char chj = s.charAt(j);
                if (--counts[chj] == 0)
                    cou--;
                j++;
            }
            max = Math.max(max, i-j+1);
            i++;
        }
        return max;
    }
}
