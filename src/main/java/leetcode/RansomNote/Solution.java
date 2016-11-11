package leetcode.RansomNote;

/**
 * Created by ymyue on 9/28/16.
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] counts = new int[26];
        for (char ch : magazine.toCharArray())
            counts[ch-'a']++;
        for (char ch : ransomNote.toCharArray()) {
            if (--counts[ch-'a'] < 0)
                return false;
        }
        return true;
    }
}
