package leetcode.FindtheDifference;

/**
 * Created by ymyue on 9/18/16.
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Solution {
    public char findTheDifference(String s, String t) {
        int[] count = new int[26];
        for (char ch : t.toCharArray())
            count[ch-'a']++;
        for (char ch : s.toCharArray())
            count[ch-'a']--;
        for (int i = 0; i < 26; i++)
            if (count[i] == 1)
                return (char)(i+'a');
        throw new IllegalArgumentException();
    }
}
