package leetcode.LongestSubstringWithoutRepeatingCharacters;

/**
 * Created by ymyue on 11/15/15.
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] pos = new int[256];
        for (int i = 0; i < pos.length; i++)
            pos[i] = -1;
        int start = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = (int)s.charAt(i);
            if (pos[index] >= start) {
                start = pos[index] + 1;
                pos[index] = i;
            } else {
                pos[index] = i;
                maxLen = Math.max(maxLen, i - start + 1);
            }
        }
        maxLen = Math.max(maxLen, s.length() - start);
        return maxLen;
    }
}
