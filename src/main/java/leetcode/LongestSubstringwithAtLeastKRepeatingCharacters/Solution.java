package leetcode.LongestSubstringwithAtLeastKRepeatingCharacters;

/**
 * Created by ymyue on 9/17/16.
 * Time complexity: O(N*logN)
 * Space complexity: O(26 * logN)
 */
public class Solution {
    public int longestSubstring(String s, int k) {
        return longestSubstring(s.toCharArray(), 0, s.length(), k);
    }

    public int longestSubstring(char[] str, int start, int end, int k) {
        if (start == end)
            return 0;
        int[] counts = new int[26];
        for (int i = start; i < end; i++)
            counts[str[i]-'a']++;
        int i = start;
        int j = start;
        int max = 0;
        while (j < end) {
            if (counts[str[j]-'a'] < k) {
                max = Math.max(max, longestSubstring(str, i, j, k));
                i = j+1;
            }
            j++;
        }
        if (i == start)
            return end - start;
        else
            return Math.max(max, longestSubstring(str, i, j, k));
    }
}
